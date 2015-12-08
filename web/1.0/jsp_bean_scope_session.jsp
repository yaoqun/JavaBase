<%@ page import="java.util.*, java.text.*" pageEncoding="utf-8" %>
<%@ page import="jsp.User" %>

<html>
<head>
	<meta charset="utf-8">
	<title>whweb</title>
</head>
<body>
	<!-- html内容 -->
	<h3>session查看JavaBean</h3>
	<hr>

	用户名: <%= ((User)session.getAttribute("myUser")).getUserName() %><br>
	年龄: <%= ((User)session.getAttribute("myUser")).getUserAge() %>

</body>
</html>