<%@ page import="java.util.*" pageEncoding="utf-8" %>
<%@ page import="mysql.DbHelper" %>

<html>
<head>
	<meta charset="utf-8">
	<title>bookstore</title>
</head>
<body>
	<h3>书店</h3>
	<hr>

	<%
	List<String> books = DbHelper.getInstance().getAllBookNames();

	for (String bookname : books) {
		try {
			String param = java.net.URLEncoder.encode(bookname, "utf-8");
			String s = String.format(
				"<a href=\"detail.jsp?bookname=%s\">%s</a><br>",
				param, bookname);
			out.print(s);
		}
		catch(Exception e) {}
	}
	%>

</body>
</html>