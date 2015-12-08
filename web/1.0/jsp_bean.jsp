<%@ page import="java.util.*, java.text.*" pageEncoding="utf-8" %>

<html>
<head>
	<meta charset="utf-8">
	<title>whweb</title>
</head>
<body>
	<!-- html内容 -->
	<h3>JSP使用JavaBean</h3>
	<hr>

	<%
	request.setCharacterEncoding("utf-8");
	%>

	<%-- 实例化一个Bean对象 --%>
	<jsp:useBean id="myUser" class="jsp.User" scope="page" />

	<jsp:setProperty name="myUser" property="*" />

	用表达式获取Bean属性值<br>
	用户名: <%= myUser.getUserName() %><br>
	年龄: <%= myUser.getUserAge() %><br><br>

	用getProperty动作元素获取Bean属性值<br>
	用户名: <jsp:getProperty name="myUser" property="userName" /><br>
	年龄: <jsp:getProperty name="myUser" property="userAge" />

</body>
</html>