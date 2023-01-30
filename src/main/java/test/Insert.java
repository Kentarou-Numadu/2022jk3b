package test;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.DataBean;
import dao.DAO;


@WebServlet("/insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Insert() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String submit = (String) request.getParameter("submit");
		if (submit == null || !submit.equals("1")) {
			response.sendRedirect("displayall");
			return;
		}
		
		String strId = request.getParameter("id");
		String strSimei = request.getParameter("simei");
		String strFurigana = request.getParameter("furigana");
		String strBirth = request.getParameter("birth");
		String strZip = request.getParameter("zip");
		String strAddress = request.getParameter("address");
		String strTelephone = request.getParameter("telephone");
		String strMail = request.getParameter("mail");
		String strStatus = request.getParameter("status");
		String strStatus_day = request.getParameter("status_day");
		String strP_Name = request.getParameter("p_name");
		String strP_Furigana = request.getParameter("p_furigana");
		String strP_Zip = request.getParameter("p_zip");
		String strP_Addres = request.getParameter("p_address");
		String strP_Telephone = request.getParameter("p_telephone");
		String strP_Mail = request.getParameter("p_mail");
		
		
		List<String> message = new ArrayList<String>();//---メッセージ格納
		
		//---エラーチェック
		boolean errSw = false;
		
		Date Birth = null;
		Date Status_day = null;
		int id = -1;
		int status = -1;
		strTelephone = strTelephone.replaceAll("　", ""); //全角スペースを空文字に置換
        strTelephone = strTelephone.replaceAll(" ", "");
        strP_Telephone = strP_Telephone.replaceAll("　", ""); //全角スペースを空文字に置換
        strP_Telephone = strP_Telephone.replaceAll(" ", "");
		String strPattern = "^[0-9][0-9¥¥-]*$";
		Pattern p = Pattern.compile(strPattern); /* 正規表現オブジェクトの準備 */
		String strPattern2 = "^[0-9]{7}$";
		Pattern p2 = Pattern.compile(strPattern2);
		Matcher m = p.matcher(strTelephone); 
		Matcher m2 = p2.matcher(strZip);
		Matcher m3 = p2.matcher(strP_Zip);
		Matcher m4 = p.matcher(strP_Telephone);
		//---番号が空か、値が数値かを判断
		if(strId == null || strId == "") {
			message.add("番号が入力されていません");
			errSw = true;
		}else {
			try {
				id = Integer.parseInt(strId);
			}catch(Exception e) {
				message.add("番号が数字ではありません");
				errSw = true;
			}
		}
		//---氏名が空かどうか
		if(strSimei == null || strSimei == "") {
			message.add("氏名（漢字）が入力されていません");
			errSw = true;
		}
		
		if(strFurigana == null || strFurigana == "") {
			message.add("氏名（ふりがな）が入力されていません");
			errSw = true;
		}
		
		if(strBirth == null || strBirth == "") {
			message.add("生年月日が入力されていません");
			errSw = true;
		}else{
			try {
				Birth = Date.valueOf(strBirth);
			}catch(Exception e) {
				message.add("生年月日が日付型ではありません");
				errSw = true;
			}
		}
			
		
		if(strZip == null || strZip == "") {
			message.add("本人郵便番号が入力されていません");
			errSw = true;
		
		}else if(m2.find()) {
			
		}else {
			message.add("本人郵便番号に七桁までの数字を入れて下さい");
			errSw = true;
		}
		
		if(strAddress == null || strAddress == "") {
			message.add("本人住所が入力されていません");
			errSw = true;
		}
		
		if(strTelephone == null || strTelephone == "") {
			message.add("本人電話番号が入力されていません");
			errSw = true;
		}else if(m.find()) {
			
		}else {
			message.add("本人電話番号に数字とハイフン（-）を入れて下さい");
			errSw = true;
		}
		
		if(strMail == null || strMail == "") {
			message.add("本人メールアドレスが入力されていません");
			errSw = true;
		}
		
		if(strStatus == null || strStatus == "") {
			message.add("在籍状態が入力されていません");
			errSw = true;
		}else {
			try {
				status = Integer.parseInt(strStatus);
			}catch(Exception e) {
				message.add("在籍状態が数字ではありません");
				errSw = true;
			}
		}
		
		if(strStatus_day == null || strStatus_day == "") {
			message.add("在籍状態確定日が入力されていません");
			errSw = true;
		}else{
			try {
				Status_day = Date.valueOf(strStatus_day);
			}catch(Exception e) {
				message.add("在籍状態確定日が日付型ではありません");
				errSw = true;
			}
		}
		
		if(strP_Name == null || strP_Name == "") {
			message.add("保護者氏名（漢字）が入力されていません");
			errSw = true;
		}
		
		if(strP_Furigana == null || strP_Furigana == "") {
			message.add("保護者氏名（ふりがな）が入力されていません");
			errSw = true;
		}
		
		if(strP_Zip == null || strP_Zip == "") {
			message.add("保護者郵便番号が入力されていません");
			errSw = true;
		}else if(m3.find()) {
			
		}else {
			message.add("保護者郵便番号に七桁までの数字を入れて下さい");
			errSw = true;
		}
		
		if(strP_Addres == null || strP_Addres == "") {
			message.add("保護者住所が入力されていません");
			errSw = true;
		}
		
		if(strP_Telephone == null || strP_Telephone == "") {
			message.add("保護者電話番号が入力されていません");
			errSw = true;
		}else if(m4.find()) {
			
		}else {
			message.add("保護者電話番号に数字とハイフン（-）を入れて下さい");
			errSw = true;
		}
		
		if(strP_Mail == null || strP_Mail == "") {
			message.add("保護者メールアドレスが入力されていません");
			errSw = true;
		}
	
	//---エラーデータでなければ登録
	if (!errSw) {
		//---すでに登録済みのidかを調べる。
		DAO dao = new DAO();
		 
		if (!dao.isExists(strId)) {
			DataBean bean = new DataBean();
			bean.setId(id);
			bean.setName(strSimei);
			bean.setFurigana(strFurigana);
			bean.setBirth(Birth);
			bean.setZip(strZip);
			bean.setAddress(strAddress);
			bean.setTelephone(strTelephone);
			bean.setMail(strMail);
			bean.setStatus(status);
			bean.setStatus_day(Status_day);
			bean.setP_Name(strP_Name);
			bean.setP_Furigana(strP_Furigana);
			bean.setP_Zip(strP_Zip);
			bean.setP_Address(strP_Addres);
			bean.setP_Telephone(strP_Telephone);
			bean.setP_Mail(strP_Mail);
			
			int result = dao.insertData(bean);
			if (result == 0) {
				message.add("登録できませんでした。");
			} else {
				message.add("登録完了しました。");
			}
		} else {
			message.add("IDが重複しています。");
		}
	}//---メッセージ表示用のjspへ遷移
	request.setAttribute("message", message);
	request.getRequestDispatcher("Insert.jsp").forward(request, response);
	}

}
