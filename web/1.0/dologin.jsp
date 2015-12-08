<%@ page import="java.util.Arrays" pageEncoding="utf-8" %>

<html>
<head>
	<meta charset="utf-8">
	<title>whweb</title>
</head>
<body>
	<!-- html内容 -->
	<h3>登录成功</h3>
	<hr>

	<% request.setCharacterEncoding("utf-8"); %>

	用户名: <%= request.getParameter("username") %><br>
	课程: 
	<%
	String[] courses = request.getParameterValues("courses");
	if (courses != null)
		out.println(Arrays.toString(courses));
	%>

	<hr>
	请求包体长度: <%=request.getContentLength() %><br>
	客户端IP: <%=request.getRemoteAddr() %>

</body>
</html>