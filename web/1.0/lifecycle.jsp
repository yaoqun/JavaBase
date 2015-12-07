<%@ page pageEncoding="utf-8" %>

<html>
<head>
	<meta charset="utf-8">
	<title>whweb</title>
</head>
<body>
	<!-- html内容 -->
	<h3>JSP页面生命周期</h3>
	
	<%!
	private int m_initCnt = 0;
	private int m_serviceCnt = 0;
	private int m_destoryCnt = 0;
	%>

	<%!
	public void jspInit() {
		m_initCnt++;
		System.out.println("jsp init");
	}

	public void jspDestory() {
		m_destoryCnt++;
		System.out.println("jsp destory");
	}
	%>

	<%
	m_serviceCnt++;
	%>

	jspInit()调用次数:     <%= m_initCnt %><br>
	_jspService()调用次数: <%= m_serviceCnt %><br>
	jspDestory()调用次数:  <%= m_destoryCnt %><br>

</body>
</html>