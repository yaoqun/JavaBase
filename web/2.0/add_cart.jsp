<%@ page import="java.util.*" pageEncoding="utf-8" %>
<%@ page import="mysql.DbHelper" %>

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
String bookid = request.getParameter("bookid");
if (bookname==null || bookid==null)
{
	response.sendRedirect("index.jsp");
	return;
}
bookname = urlEncode(bookname);

Cookie[] cs = request.getCookies();
if (cs != null) {
	for (Cookie c : cs) {
		if (c.getValue().equals(bookname)) {
			response.sendRedirect("index.jsp");
			return;
		}
	}
}

response.addCookie(new Cookie(bookid, bookname));
response.sendRedirect("index.jsp");
%>