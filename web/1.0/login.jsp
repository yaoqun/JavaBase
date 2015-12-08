<%@ page pageEncoding="utf-8" %>

<html>
<head>
	<meta charset="utf-8">
	<title>whweb</title>
</head>
<body>
	<!-- html内容 -->
	<h3>登录</h3>
	<hr>

	<form action="dologin.jsp" name="loginform" method="post"> <!-- method="get" -->
	<table>
		<tr>
			<td>用户名: </td>
			<td><input type="text" name="username"/></td>
		</tr>
		</tr>
			<td>密码: </td>
			<td><input type="text" name="username"/></td>
		</tr>
		<tr>
			<td>课程: </td>
			<td>
				<input type="checkbox" name="courses" value="语文">语文
				<input type="checkbox" name="courses" value="数学">数学
				<input type="checkbox" name="courses" value="英语">英语
			</td>
		</tr>
	</table>
	<input type="submit"/>
	</form>

	<hr>
	<a href="dologin.jsp?username=张三">url传参数</a>

</body>
</html>