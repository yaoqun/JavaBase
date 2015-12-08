<%@ page import="java.util.*, java.text.*" pageEncoding="utf-8" %>

<html>
<head>
	<meta charset="utf-8">
	<title>whweb</title>
</head>
<body>
	<!-- html内容 -->
	<h3>session内置对象</h3>
	<hr>

	<%
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date(session.getCreationTime());

	session.setMaxInactiveInterval(5);
	%>

	session创建时间: <%= sdf.format(date) %><br>
	session ID: <%= session.getId() %><br>
	session间隔: <%= session.getMaxInactiveInterval() %>秒<br>

	<%
	session.setAttribute("name", "张三");
	session.setAttribute("age", 20);
	%>

	<hr>
	<a href="session_1.jsp">查看所有属性(在间隔时间内点击)</a>

</body>
</html>