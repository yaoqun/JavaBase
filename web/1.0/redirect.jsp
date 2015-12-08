<%@ page pageEncoding="utf-8" %>

<html>
<head>
	<meta charset="utf-8">
	<title>whweb</title>
</head>
<body>
	<!-- html内容 -->
	<h3>请求重定向</h3>
	<hr>

	<%
	request.setAttribute("属性", "123");
	response.sendRedirect("/doaccept.jsp?type=redirect");
	%>

</body>
</html>