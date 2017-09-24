<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>无标题文档</title>
</head>

<body>

	<script language='javascript'>alert('<%=request.getAttribute("result")%>');</script>
	<script type="text/javascript">
		window.opener=null;window.open('','_self');window.close();
	</script>
</body>
</html>
