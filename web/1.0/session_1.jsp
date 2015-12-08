<%@ page import="java.util.*, java.text.*" pageEncoding="utf-8" %>

<html>
<head>
	<meta charset="utf-8">
	<title>whweb</title>
</head>
<body>
	<!-- html内容 -->
	<h3>显示session的所有属性</h3>
	<hr>

	session ID: <%= session.getId() %>
	<br><br>

	<%
	String[] attrNames = session.getValueNames();
	if (attrNames != null) {
		for (String name : attrNames)
			out.println(name + ": " + session.getAttribute(name) + "<br>");
	}
	%>

</body>
</html>