<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="info.searchman.*"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>社員一覧</title>
<style>
table {
	border-collapse: collapse;
	/* セルの境界線を重ねて単線にする */
}

th, td {
	border: 1px solid black;
	/* セルの境界線のスタイルを設定 */
	padding: 10px;
}
</style>
</head>

<body>
	<h1>社員一覧</h1>

	<table border="1">
		<tr bgcolor="#cccccc">
			<th>ID</th>
			<th>名前</th>
			<th>姓</th>
			<th>年</th>
			<th>住所</th>
			<th>変更</th>
			<th>削除</th>
		</tr>

		<%
		//社員リストを作る
		ArrayList<ShainBean> shainList = new ArrayList<>();

		//社員１を作る
		ShainBean shain1 = new ShainBean();
		shain1.setId(101);
		shain1.setName("鈴木義信");
		shain1.setSei("男");
		shain1.setNen(2003);
		shain1.setAddress("宮城県仙台市");
		//社員リストに追加
		shainList.add(shain1);

		//社員２を作る
		ShainBean shain2 = new ShainBean();
		shain2.setId(102);
		shain2.setName("佐藤香織");
		shain2.setSei("女");
		shain2.setNen(2004);
		shain2.setAddress("福岡県福岡市");
		//社員リストに追加
		shainList.add(shain2);
		%>

		<%
		for (ShainBean shain : shainList) {
		%>
		<tr>
			<td><%=shain.getId()%></td>
			<td><%=shain.getName()%></td>
			<td><%=shain.getSei()%></td>
			<td><%=shain.getNen()%></td>
			<td><%=shain.getAddress()%></td>
			<td>変更</td>
			<td>削除</td>
		</tr>
		<%
		}
		%>

	</table>
	<p></p>
	<!-- 「社員を登録する」ボタン -->
	<form action="ShainInsert">
		<input type="submit" value="社員を登録する">
	</form>
</body>

</html>