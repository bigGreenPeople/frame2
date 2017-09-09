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
    <title>简单的学生信息管理系统</title>
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
<!--
body {
	margin-top: 0px;
	margin-bottom: 0px;
}
-->
</style>
  </head>
  <body background="student/background.GIF">
  <center>
  <jsp:include page="student/top.jsp"/>
  <br/>
  <h2><font color=red>简单学生信息管理系统</font></h2>
  <form action="${pageContext.request.contextPath }/user_login" method="post">
  用户名:<input type="text" name="uname"/><br/>
  密&nbsp;&nbsp;码:<input type="password"  name="upass"/>
  <br/>
  <input type="submit" value="登  录"/>&nbsp;
  <input type="reset"  value="取  消"/>
  <br/>  <br/>  <br/>
  <a href="register.jsp">用户注册</a>
  &nbsp;&nbsp;
  <a href="reback.jsp">找回密码</a>
  </form>
  <br/>
  <br/>
   <br/>
   <br/>
    <br/>
    <br/>
   <br/>
    <br/>
   <jsp:include page="student/bottom.jsp"/>
   </center>
  </body>
</html>
