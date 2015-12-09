<%@ page pageEncoding="utf-8" %>

<html>
<head>
	<meta charset="utf-8">
	<title>whweb</title>
</head>
<body>
	<!-- html内容 -->
	<h3>web 3.0</h3>
	<hr>

	<%
	System.out.println("客户端访问: index.jsp");
	%>

	<a href="/servlet_demo">Servlet-Get</a>
	<br><br>

	<form action="/servlet_demo" method="post">
		<input type="submit" value="Servlet-Post" />
	</form>

</body>
</html>