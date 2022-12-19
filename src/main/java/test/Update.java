package test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.DataBean;
import dao.DAO;


@WebServlet("/update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Update() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		DataBean bean = null;
		boolean errflag = false;
		
		//--- 送信されたIDを受け取る　存在しなければdisplayallへ戻る
		String strId = request.getParameter("id");
		if(strId == null || strId =="") {
			errflag = true;
		}else {
			//データベースから該当するデータを取得するなければdisplayallへ戻る
			DAO dao = new DAO();
			bean = dao.getOneRec(strId);
			if(bean ==null) {
				errflag = true;
			}
		}
		//---エラーあればdisplayallへ戻る
		if(errflag) {
				response.sendRedirect("displayall");
			}else {
				//---更新用のフォームを呼び出す
				request.setAttribute("data", bean);
				request.getRequestDispatcher("Update.jsp").forward(request, response);
			}
	}

}
