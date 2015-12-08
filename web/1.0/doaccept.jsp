<%@ page pageEncoding="utf-8" %>

<html>
<head>
	<meta charset="utf-8">
	<title>whweb</title>
</head>
<body>
	<!-- html内容 -->
	<h3>接收: 请求重定向、请求转发</h3>
	<hr>

	<%
	String type = request.getParameter("type");

	if (type == null)
		return;
	else if (type.equals("redirect"))
		out.println("请求重定向<br>");
	else if (type.equals("forward"))
		out.println("请求转发<br>");
	else
		return;

	out.println("request中保存的属性: " +
				request.getAttribute("属性"));
	%>

</body>
</html>