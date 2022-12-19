<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="bean.DataBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	//---データの取得
	DataBean bean = (DataBean) request.getAttribute("data");
	if (bean == null) {
		response.sendRedirect("displayall");
		return;
	}
	%>
	<h1>データの修正</h1>
	<form method="get" action="updatego">
		<p>ID：<%=bean.getId()%></p>
		<p>氏名（漢字）：<input type="text" name="simei" value="<%=bean.getName()%>"></p>
		<p>氏名（ふりがな）<input type="text" name="furigana" value="<%=bean.getFurigana()%>"></p>
		<p>生年月日<input type="date" name="birth" value="<%=bean.getBirth()%>"></p>
		<p>本人郵便番号<input type="text" name="zip" maxlength="7" value="<%=bean.getZip()%>"></p>
		<p>本人住所<input type="text" name="address" value="<%=bean.getAddress()%>"></p>
		<p>本人電話番号<input type="text" name="telephone" value="<%=bean.getTelephone()%>"></p>
		<p>本人メールアドレス<input type="email" name="mail" value="<%=bean.getMail()%>"></p>
		<p>在籍状態<input type="number" name="status" value="<%=bean.getStatus()%>"></p>
		<p>在籍状態確定日<input type="date" name="status_day" value="<%=bean.getStatus_day()%>"></p>
		<p>保護者氏名（漢字）<input type="text" name="p_name" value="<%=bean.getP_Name()%>"></p>
		<p>保護者氏名（ふりがな）<input type="text" name="p_furigana" value="<%=bean.getP_Furigana()%>"></p>
		<p>保護者郵便番号<input type="text" name="p_zip" maxlength="7" value="<%=bean.getP_Zip()%>"></p>
		<p>保護者住所<input type="text" name="p_address" value="<%=bean.getP_Address()%>"></p>
		<p>保護者電話番号<input type="text" name="p_telephone" value="<%=bean.getP_Telephone()%>"></p>
		<p>保護者メールアドレス<input type="email" name="p_mail" value="<%=bean.getP_Mail()%>"></p>
		
		<input type="hidden" name="id" value="<%=bean.getId() %>">
		<button type="submit" name="submit" value="1">変更</button>
		<button type="submit" name="submit" value="2">キャンセル</button>
		<button type="reset">リセット</button>

</body>
</html>