<%@ page pageEncoding="utf-8" %>

<html>
<head>
	<meta charset="utf-8">
	<title>whweb</title>
</head>
<body>
	<!-- html内容 -->
	<h3>请求转发</h3>
	<hr>

	<%
	request.setAttribute("属性", "123");

	String forwardUrl = "doaccept.jsp?type=forward";
	request.getRequestDispatcher(forwardUrl).forward(request, response);
	%>

</body>
</html>