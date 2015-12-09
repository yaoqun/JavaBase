<%@ page import="java.util.*" pageEncoding="utf-8" %>
<%@ page import="mysql.DbHelper" %>
<%@ page import="bookstore.Book" %>

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
	<h3>图书信息</h3>
	<hr>

	<%!
	private String urlEncode(String s) {
		try {
			return java.net.URLEncoder.encode(s, "utf-8");
		}
		catch (Exception e) {
			return null;
		}
	}
	%>

	<%
	String bookname = request.getParameter("bookname");
	if (bookname == null)
	{
		response.sendRedirect("index.jsp");
		return;
	}
	Book book = DbHelper.getInstance().getBook(bookname);
	if (book == null)
	{
		response.sendRedirect("index.jsp");
		return;
	}

	out.print("书名: " + book.getBookname() + "<br>");
	out.print("作者: " + book.getAuthor() + "<br>");
	out.print("出版社: " + book.getPublisher() + "<br>");
	out.print("价格: ￥" + book.getPrice() + "<br><br>");

	out.print( String.format(
		"<a href=add_cart.jsp?bookname=%s&bookid=%d>加入购物车</a>",
		urlEncode(bookname), book.getBookid()
	));
	%>

</body>
</html>