<%@ page import="java.util.*, java.text.*" pageEncoding="utf-8" %>

<html>
<head>
	<meta charset="utf-8">
	<title>whweb</title>
</head>
<body>
	<!-- html内容 -->
	<h3>输入用户信息</h3>
	<hr>

	<form action="jsp_bean.jsp" name="userInfoForm" method="post"> <!-- method="get" -->
	<table>
		<tr>
			<td>名称: </td>
			<td><input type="text" name="userName"/></td>
		</tr>
		</tr>
			<td>年龄: </td>
			<td><input type="text" name="userAge"/></td>
		</tr>
	</table>
	<input type="submit"/>
	</form>

</body>
</html>