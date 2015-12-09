<%@ page pageEncoding="utf-8" %>

<html>
<head>
	<meta charset="utf-8">
	<title>whweb</title>
</head>
<body>
	<!-- html内容 -->
	<h3>过滤器初始化参数</h3>
	<hr>

	admin: <%= request.getAttribute("filter-param") %>

</body>
</html>