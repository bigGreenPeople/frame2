<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<title>注册用户信息</title>
<style type="text/css">
<!--
body {
	margin-top: 0px;
	margin-bottom: 0px;
}
-->
</style>
</head>
<body background="background.GIF">
<center>
<jsp:include page="student/top.jsp"/>
<form action="${pageContext.request.contextPath }/user_register" method="post">
    <table width="424" height="57" border="1">
     <caption align="center">
     <font color=red size=5><b>用户注册</b></font>
     </caption>
    <tr><td>用户ID:</td> <td><input type="text" name="uid"/></td></tr>
    <tr><td>姓名:</td> <td><input type="text" name="uname"/></td></tr>
    <tr><td>密码:</td> <td><input type="text" name="upass"/></td></tr>
    <tr align="center">
    <td colspan="2">
    <input type="submit" value="注   册"/>
    &nbsp;&nbsp;
    <input type="reset" value="取   消"/>
    </td></tr>
    </table>
  </form>
<jsp:include page="student/bottom.jsp"/>
</center>
</body>
</html>
