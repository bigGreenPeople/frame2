<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>手机销售系统</title>
</head>

<body>

	<script language='javascript'>alert('<%=request.getAttribute("result")%>'); window.location.href="${pageContext.request.contextPath }/type_findAllBigType";</script>

</body>
</html>
