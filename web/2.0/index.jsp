<%@ page import="java.util.*" pageEncoding="utf-8" %>
<%@ page import="mysql.DbHelper" %>

<html>
<head>
	<meta charset="utf-8">
	<title>bookstore</title>
	<style type="text/css">
		a:link {color:#3030ff;}
		a:visited {color:#3030ff;}
	</style>
</head>
<body>
	<h3>书店</h3><hr>

	<%!
	private String urlEncode(String s) {
		try {
			return java.net.URLEncoder.encode(s, "utf-8");
		}
		catch (Exception e) {
			return null;
		}
	}

	private String urlDecode(String s) {
		try {
			return java.net.URLDecoder.decode(s, "utf-8");
		}
		catch (Exception e) {
			return null;
		}
	}
	%>

	<%
	List<String> books = DbHelper.getInstance().getAllBookNames();
	if (books == null)
		return;

	for (String bookname : books) {
		try {
			String s = String.format(
				"<a href=\"detail.jsp?bookname=%s\">%s</a><br>",
				urlEncode(bookname), bookname);
			out.print(s);
		}
		catch(Exception e) {}
	}
	%>
	<br><br>

	<h3>购物车</h3><hr>
	<%
	Cookie[] cs = request.getCookies();
	if (cs != null) {
		for (Cookie c : cs) {
			if (c.getName().equalsIgnoreCase("JSESSIONID"))
				continue;
			String bookname = urlDecode(c.getValue());
			String s = String.format(
				"%s\t\t%s\t\t<a href=\"del_cart.jsp?bookname=%s\">删除</a><br>",
				c.getName(), bookname, c.getValue());
			out.print(s);
		}
	}
	%>

</body>
</html>