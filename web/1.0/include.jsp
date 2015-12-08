<%@ page pageEncoding="utf-8" %>

<html>
<head>
	<meta charset="utf-8">
	<title>whweb</title>
</head>
<body>
	<!-- html内容 -->
	<h3>include指令</h3>
	<%@ include file="date.jsp" %>
	<hr>

	<h3>include动作</h3>
	<jsp:include page="date.jsp" flush="true" />
	<hr>

</body>
</html>