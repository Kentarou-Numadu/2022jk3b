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


@WebServlet("/updatego")
public class UpdateGo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UpdateGo() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//---変更ボタンクリック以外は一覧へ戻す
		String submit = (String) request.getParameter("submit");
		if (submit == null || !submit.equals("1")) {
			response.sendRedirect("displayall");
			return;
		}
		
		List<String> list = new ArrayList();
		//---フォームデータの取得
		DataBean bean = new DataBean();
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
		//---IDの設定（エラーチェックもする）
		try {
			bean.setId(Integer.parseInt(strId));
		}catch(Exception e) {
			list.add("IDが数値でありません。");
		}
		
		//---氏名の設定（エラーチェックもする）
		if (strSimei.isEmpty()) {
			list.add("氏名（漢字）の値が未設定になっています");
		}else {
			bean.setName(strSimei);
		}
		
		if (strFurigana.isEmpty()) {
			list.add("氏名（ふりがな）の値が未設定になっています");
		}else {
			bean.setFurigana(strFurigana);
		}
		
		if (strBirth.isEmpty()) {
			list.add("生年月日の値が未設定になっています");
		}else {
			bean.setBirth(strBirth);
		}
		
		if (strZip.isEmpty()) {
			list.add("本人郵便番号の値が未設定になっています");
		}else {
			bean.setZip(strZip);
		}
		
		if (strAddress.isEmpty()) {
			list.add("本人住所の値が未設定になっています");
		}else {
			bean.setAddress(strAddress);
		}
		
		if (strTelephone.isEmpty()) {
			list.add("本人電話番号の値が未設定になっています");
		}else {
			bean.setTelephone(strTelephone);
		}
		
		if (strMail.isEmpty()) {
			list.add("本人メールアドレスの値が未設定になっています");
		}else {
			bean.setMail(strMail);
		}

		try {
			bean.setStatus(Integer.parseInt(strStatus));
		}catch(Exception e) {
			list.add("在籍状態が数値でありません。");
		}
		
		if (strStatus_day.isEmpty()) {
			list.add("在籍状態確定日の値が未設定になっています");
		}else {
			bean.setStatus_day(strStatus_day);
		}
		
		if (strP_Name.isEmpty()) {
			list.add("保護者氏名（漢字）の値が未設定になっています");
		}else {
			bean.setP_Name(strP_Name);
		}
		
		if (strP_Furigana.isEmpty()) {
			list.add("保護者氏名（ふりがな）の値が未設定になっています");
		}else {
			bean.setP_Furigana(strP_Furigana);
		}
		
		if (strP_Zip.isEmpty()) {
			list.add("保護者郵便番号の値が未設定になっています");
		}else {
			bean.setP_Zip(strP_Zip);
		}
		
		if (strP_Addres.isEmpty()) {
			list.add("保護者住所の値が未設定になっています");
		}else {
			bean.setP_Address(strP_Addres);
		}
		
		if (strP_Telephone.isEmpty()) {
			list.add("保護者電話番号の値が未設定になっています");
		}else {
			bean.setP_Telephone(strP_Telephone);
		}
		
		if (strP_Mail.isEmpty()) {
			list.add("保護者メールアドレスの値が未設定になっています");
		}else {
			bean.setP_Mail(strP_Mail);
		}
		
		
		//---DAOのupdateataを呼び出す。
		if (list.size()== 0) {
			DAO dao = new DAO();
			int result = dao.updateData(bean);
			if (result == 1) {
				list.add("修正完了しました。");
			}else {
				list.add("修正できませんでした。");
			}
		}
		//---結果表示のｊjspへ遷移
		request.setAttribute("message", list);
		request.getRequestDispatcher("UpdateGo.jsp").forward(request, response);
	}

}
