<%@ page import="java.util.*" pageEncoding="utf-8" %>
<%@ page import="mysql.DbHelper" %>
<%@ page import="bookstore.Book" %>

<html>
<head>
	<meta charset="utf-8">
	<title>bookstore</title>
</head>
<body>
	<h3>Book</h3>
	<hr>

	<%
	String bookname = request.getParameter("bookname");
	Book book = DbHelper.getInstance().getBook(bookname);

	out.print("书名: " + book.getBookname() + "<br>");
	out.print("作者: " + book.getAuthor() + "<br>");
	out.print("出版社: " + book.getPublisher() + "<br>");
	out.print("价格: ￥" + book.getPrice() + "<br>");
	%>

</body>
</html>