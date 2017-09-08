<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>处理找回密码</title>
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
<form action="" method="post">
    <table width="424" height="57" border="1">
     <caption align="center">
     <font color=red size=5><b>恭喜，你找回的密码信息如下：</b></font>
     </caption>
    <tr><td>用户名:</td> <td>lisi</td></tr>
    <tr><td>姓名:</td> <td>李四</td></tr>
    <tr><td>密码:</td> <td>123456</td></tr>
    </table>
  </form>
  <br/>
  <h3><a href="index.jsp">返回进行登录</a></h3>
<jsp:include page="student/bottom.jsp"/>
</center>
</body>
</html>
