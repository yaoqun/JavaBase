<%@ page import="javax.servlet.http.Cookie" pageEncoding="utf-8" %>

<html>
<head>
	<meta charset="utf-8">
	<title>whweb</title>
</head>
<body>
	<!-- html内容 -->
	<h3>保存Cookie</h3>
	<hr>

	<%!
	private int m_callCnt = 0;
	%>

	<%
	m_callCnt++;
	response.addCookie( new Cookie("useName", "张三") );
	response.addCookie( new Cookie("accessCnt", String.valueOf(m_callCnt)) );
	out.println("保存了2个Cookie: useName, accessCnt<hr>");

	out.println("第" + m_callCnt + "次访问取到的Cookie<br>");
	Cookie[] cooks = request.getCookies();
	if (cooks != null) {
		for (Cookie cook : cooks) {
			out.println(cook.getName() + ": " + cook.getValue() + "<br>");
		}
	}
	%>

</body>
</html>