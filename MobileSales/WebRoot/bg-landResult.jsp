<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>

<html>
<head>
 <link href="../css/css.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>登录结果</title>
</head>

<body>
<%if(request.getAttribute("result")==null){%>
	<script language=javascript>window.location.href='${pageContext.request.contextPath}/order_findAllOrder';</script>
	<%}else{%>
	<script language='javascript'>alert('<%=request.getAttribute("result")%>');location.href='bg-land.jsp'</script>
	<%}%>
</body>
</html>
