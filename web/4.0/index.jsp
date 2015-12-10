<%@ page import="java.util.*" pageEncoding="utf-8" %>

<html>
<head>
	<meta charset="utf-8">
	<title>whweb</title>
</head>
<body>
	<!-- html内容 -->
	<h3>监听器</h3><hr>

	<%
	request.setAttribute("attr", "增加Attr");
	request.setAttribute("attr", "修改Attr");
	request.removeAttribute("attr");

	String client = request.getHeader("user-agent");
	session.setAttribute("user", new web.User(client, 20));

	session.setMaxInactiveInterval(10);
	%>

	当前在线数: <%= session.getServletContext().getAttribute("usernum") %>
	<br><br><br>

	<h3>IP地址</h3><hr>

	<%
	javax.servlet.ServletContext sctx = session.getServletContext();

	Map<String, String> userip =
			(Map<String, String>) sctx.getAttribute("userip");

	if (userip == null) {
		userip = new HashMap<String, String>();
		sctx.setAttribute("userip", userip);
	}

	boolean isSetIP = (boolean) session.getAttribute("isSetIP");
	if ( ! isSetIP ) {
		session.setAttribute("isSetIP", true);

		String v = request.getHeader("user-agent") + "<br>" +
				   request.getRemoteAddr();

		userip.put(session.getId(), v);
	}

	for (String s : userip.values()) {
		out.print(s + "<br><br>");
	}
	%>

</body>
</html>