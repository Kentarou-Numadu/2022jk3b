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


@WebServlet("/search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Search() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		try {
			DAO dao = new DAO();
			
			String strPage = (String) request.getParameter("page");
			int page = 1;
			if (strPage != null) {
				try {
					page = Integer.parseInt(strPage);
				} catch (Exception e) {
					page = 1;
				}
			}
			
			List<DataBean> list = new ArrayList<DataBean>();
			String keyword = request.getParameter("keyword");
			list= dao.getAllData(page,keyword);
			
			
			request.setAttribute("data", list);
			
			request.setAttribute("page", page);
			
			request.setAttribute("allpage", dao.getMaxPage(keyword));
			
			request.setAttribute("keyword", keyword);
			// jspへ遷移
			request.getRequestDispatcher("Display.jsp").forward(request, response);
			
			
		}catch(Exception e) {
			response.getWriter().print(e.getMessage());
		}
		
	}
}
