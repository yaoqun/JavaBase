<%@ page pageEncoding="utf-8" %>

<html>
<head>
	<meta charset="utf-8">
	<title>whweb</title>
</head>
<body>
	<!-- html内容 -->
	<h3>JSP内置对象</h3>
	<hr>

	<%
	out.println("> 使用内置对象out<br>");
	%>

	缓冲区大小: <%= out.getBufferSize() %><br>
	缓冲区剩余: <%= out.getRemaining() %><br>
	是否自动flush: <%= out.isAutoFlush() %><br>

</body>
</html>