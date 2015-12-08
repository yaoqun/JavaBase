<%@ page import="java.util.*, java.text.*" pageEncoding="utf-8" %>

<html>
<head>
	<meta charset="utf-8">
	<title>whweb</title>
</head>
<body>
	<!-- html内容 -->
	<h3>JavaBean的四个作用域</h3>
	<hr>

	<jsp:useBean id="myUser" class="jsp.User" scope="session" />

	<jsp:setProperty name="myUser" property="userName" value="张三" />
	<jsp:setProperty name="myUser" property="userAge" value="20" />

	<a href="jsp_bean_scope_session.jsp">查看Bean</a>

</body>
</html>