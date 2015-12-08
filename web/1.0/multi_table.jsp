<%@ page pageEncoding="utf-8" %>

<html>
<head>
	<meta charset="utf-8">
	<title>whweb</title>
</head>
<body>
	<h3>乘法表</h3>
	<hr>

	<%!
	private void print(JspWriter out) throws Exception {
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= i; j++) {
				out.print(i + "*" + j + "=" + i*j + "&emsp;");
			}
			out.print("<br>");
		}
	}
	%>

	<% print(out); %>

</body>
</html>