<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>�ޱ����ĵ�</title>
</head>

<body>

	<script language='javascript'>alert('<%=request.getAttribute("result")%>');window.location.href='${pageContext.request.contextPath}/order_findAllOrder';</script>

</body>
</html>
