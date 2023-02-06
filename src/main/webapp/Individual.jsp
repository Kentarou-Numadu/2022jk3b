<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.DataBean"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>個別一覧</title>
	<style type="text/css">
		h1{
			margin-left:25px;
		}
		table {
			border-collapse: collapse;
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
		.formarea {
			margin-left: 30px;
			
		}
		.buttonarea {
			margin-top: 20px;
		}
		.linkStyle {
			display: inline-block;
			padding: 10px;
			color: #0000ff;
		}
		.noLinkStyle {
			display: line-block;
			padding: 10px;
			color: #999999;
		}
	</style>
</head>
<body>
	<header>
		<h1>データの編集</h1>
	</header>
	<main>
		<form class="formarea" method="get" action="select">
			<table>
				<%  //-----受け取ったデータをテーブルに表示する
				DataBean bean = (DataBean) request.getAttribute("data");
				if (bean == null) {
					response.sendRedirect("displayall");
					return;
				}
				%>
					<tr>
					<th>学籍番号</th>
					<td><label ><%=bean.getId()%></label></td>
					</tr>
					<tr>
					<th>学生氏名（漢字）</th>
					<td><label ><%=bean.getName()%></label></td>
					</tr>
					<tr>
					<th>学生氏名（ふりがな）</th>
					<td><label ><%=bean.getFurigana()%></label></td>
					</tr>
					<tr>
					<th>生年月日</th>
					<td><label ><%=bean.getBirth()%></label></td>
					</tr>
					<tr>
					<th>本人郵便番号</th>
					<td><label ><%=bean.getZip()%></label></td>
					</tr>
					<tr>
					<th>本人住所</th>
					<td><label ><%=bean.getAddress()%></label></td>
					</tr>
					<tr>
					<th>本人電話番号</th>
					<td><label ><%=bean.getTelephone()%></label></td>
					</tr>
					<tr>
					<th>本人メールアドレス</th>
					<td><label ><%=bean.getMail()%></label></td>
					</tr>
					<tr>
					<th>在籍状態</th>
					<td><label ><%=bean.getStatus()%></label></td>
					</tr>
					<tr>
					<th>在籍状態確定日</th>
					<td><label ><%=bean.getStatus_day()%></label></td>
					</tr>
					<tr>
					<th>保護者氏名（漢字）</th>
					<td><label ><%=bean.getP_Name()%></label></td>
					</tr>
					<tr>
					<th>保護者氏名（ふりがな）</th>
					<td><label ><%=bean.getP_Furigana()%></label></td>
					</tr>
					<tr>
					<th>保護者郵便番号</th>
					<td><label ><%=bean.getP_Zip()%></label></td>
					</tr>
					<tr>
					<th>保護者住所</th>
					<td><label ><%=bean.getP_Address()%></label></td>
					</tr>
					<tr>
					<th>保護者電話番号</th>
					<td><label ><%=bean.getP_Telephone()%></label></td>
					</tr>
					<tr>
					<th>保護者メール</th>
					<td><label ><%=bean.getP_Mail()%></label></td>
					</tr>
			</table>
			<div class="buttonarea">
				<button onclick="displayall">一覧へ戻る</button>
			</div>
		</form>
	</main>

</body>
</html>