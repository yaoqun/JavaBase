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
if (bookname != null) {
	bookname = urlEncode(bookname);
	Cookie[] cs = request.getCookies();
	if (cs != null) {
		for (Cookie c : cs) {
			if (c.getValue().equals(bookname)) {
				c.setMaxAge(0);
				response.addCookie(c);
				break;
			}
		}
	}
}

response.sendRedirect("index.jsp");
%>