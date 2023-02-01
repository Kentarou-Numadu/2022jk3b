<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="bean.DataBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>編集</title>
<style type="text/css">
		table {
			border-collapse: collapse;
			table-layout: fixed
		}
		table, th, td {
			border: solid 1px #000000;
		}
		th, td {
		padding: 5px;
		}
		th{
			text-align:left;
			background-color:#DDDDDD;
		}
		input{
			width:350px;
		}
		.formarea {
			margin-left: 30px;
			
		}
		.buttonarea {
			margin-top: 20px;
		}
		
</style>
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
	<form class="formarea" method="get" action="updatego">
		<table>
		<tr>
		<th>ID</th>
		<td width="360px"><%=bean.getId()%></td>
		</tr>
		<tr>
		<th>氏名（漢字）</th>
		<td><label ><input type="text" name="simei" value="<%=bean.getName()%>"></label></td>
		</tr>
		<tr>
		<th>氏名（ふりがな）</th>
		<td><label><input type="text" name="furigana" value="<%=bean.getFurigana()%>"></label></td>
		</tr>
		<tr>
		<th>生年月日</th>
		<td><label><input type="date" name="birth" value="<%=bean.getBirth()%>"></label></td>
		</tr>
		<tr>
		<th>本人郵便番号</th>
		<td><label><input type="text" name="zip" maxlength="7" value="<%=bean.getZip()%>"></label></td>
		</tr>
		<tr>
		<th>本人住所</th>
		<td><label><input type="text" name="address" value="<%=bean.getAddress()%>"></label></td>
		</tr>
		<tr>
		<th>本人電話番号</th>
		<td><label><input type="text" name="telephone" value="<%=bean.getTelephone()%>"></label></td>
		</tr>
		<tr>
		<th>本人メールアドレス</th>
		<td><label><input type="email" name="mail" value="<%=bean.getMail()%>"></label></td>
		</tr>
		<tr>
		<th>在籍状態</th>
		<td><label><input type="number" name="status" value="<%=bean.getStatus()%>"></label></td>
		</tr>
		<tr>
		<th>在籍状態確定日</th>
		<td><label><input type="date" name="status_day" value="<%=bean.getStatus_day()%>"></label></td>
		</tr>
		<tr>
		<th>保護者氏名（漢字）</th>
		<td><label><input type="text" name="p_name" value="<%=bean.getP_Name()%>"></label></td>
		</tr>
		<tr>
		<th>保護者氏名（ふりがな）</th>
		<td><label><input type="text" name="p_furigana" value="<%=bean.getP_Furigana()%>"></label></td>
		</tr>
		<tr>
		<th>保護者郵便番号</th>
		<td><label><input type="text" name="p_zip" maxlength="7" value="<%=bean.getP_Zip()%>"></label></td>
		</tr>
		<tr>
		<th>保護者住所</th>
		<td><label><input type="text" name="p_address" value="<%=bean.getP_Address()%>"></label></td>
		</tr>
		<tr>
		<th>保護者電話番号</th>
		<td><label><input type="text" name="p_telephone" value="<%=bean.getP_Telephone()%>"></label></td>
		</tr>
		<tr>
		<th>保護者メールアドレス</th>
		<td><label><input type="email" name="p_mail" value="<%=bean.getP_Mail()%>"></label></td>
		</tr>
		</table>
		
		<input type="hidden" name="id" value="<%=bean.getId() %>">
		<div class="buttonarea">
			<button type="submit" name="submit" value="1">変更</button>
			<button type="submit" name="submit" value="2">キャンセル</button>
			<button type="reset">リセット</button>
		</div>
</body>
</html>