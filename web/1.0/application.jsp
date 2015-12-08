<%@ page import="java.util.*, java.text.*" pageEncoding="utf-8" %>

<html>
<head>
	<meta charset="utf-8">
	<title>whweb</title>
</head>
<body>
	<!-- html内容 -->
	<h3>application内置对象</h3>
	<hr>

	<%
	application.setAttribute("name", "张三");
	application.setAttribute("age", 20);
	application.setAttribute("email", "zhangsan@sina.com");
	%>

	name: <%= application.getAttribute("name") %><br>
	age: <%= application.getAttribute("age") %><br>
	email: <%= application.getAttribute("email") %>

</body>
</html>