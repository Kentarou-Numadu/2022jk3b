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


@WebServlet("/status")
public class SelectStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectStatus() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		try {
			
			boolean errflag = false;
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
			
			String keyword = (String) request.getParameter("keyword");
			if (keyword == null) {
				keyword = "";
			}
			
			String status = (String) request.getParameter("0");
			String status1 = (String) request.getParameter("1");
			String status2 = (String) request.getParameter("2");
			String status3 = (String) request.getParameter("3");
			list= dao.selectData(page,status,status1,status2,status3);
			if(status == null&& status1==null&&status2==null&&status3==null||list==null) {
				errflag = true;
			}
			if(errflag) {
				response.sendRedirect("displayall");
			}else {
				//---更新用のフォームを呼び出す
			request.setAttribute("data", list);
			
			request.setAttribute("page", page);
			
			request.setAttribute("allpage", dao.getMaxPage(keyword));
			
			request.setAttribute("keyword", keyword);
			// jspへ遷移
			request.getRequestDispatcher("Display.jsp").forward(request, response);
			}
			
			
		}catch(Exception e) {
			response.getWriter().print(e.getMessage());
		}
	}

}
