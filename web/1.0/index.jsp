<%@ page pageEncoding="utf-8" %>

<html>
<head>
	<meta charset="utf-8">
	<title>whweb</title>
</head>
<body>
	<!-- html内容 -->
	<h3>hello 页面</h3>
	
	<%-- jsp声明 --%>
	<%!
	int a = 1, b = 2;

	int add(int a, int b) {
		return a+b;
	}

	float mean(int a, int b) {
		return ( (float)a + b ) / 2;
	}
	%>

	a = <%= a %><br>
	b = <%= b %><br>

	<%-- java代码 --%>
	<%
	// java
	int a = 1, b = 2;
	out.println("和: " + add(a, b));
	%>
	<br>

	均值: <%= mean(1, 3) %><br>

</body>
</html>