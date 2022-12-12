package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.DataBean;
import dao.DAO;

@WebServlet("/displayall")
public class DisplayAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DisplayAll() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// ---get送信されるページ番号を取得する無ければ1
		String strPage = (String) request.getParameter("page");
		int page = 1;
		if (strPage != null) {
			try {
				page = Integer.parseInt(strPage);
			} catch (Exception e) {
				page = 1;
			}
		}
		
		String keyword = (String) request.getParameter("keyword");
		if (keyword == null) {
			keyword = "";
		}
		
		// SampleDAOのgetAllDataメソッドを呼び出して全データを取り出し、listへ格納
		List<DataBean> list = new ArrayList<DataBean>();
		DAO dao = new DAO();
		list= dao.getAllData(page,keyword);
		
		// listをjspへ送るための設定
		request.setAttribute("data", list);
		
		request.setAttribute("page", page);
		
		request.setAttribute("allpage", dao.getMaxPage(keyword));
		
		request.setAttribute("keyword", keyword);
		// jspへ遷移
		request.getRequestDispatcher("Display.jsp").forward(request, response);
		
	}


	

}
