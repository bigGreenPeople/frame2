<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>ע���û���Ϣ</title>
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
     <font color=red size=5><b>�û�ע��</b></font>
     </caption>
    <tr><td>�û���:</td> <td><input type="text" name="uid"/></td></tr>
    <tr><td>����:</td> <td><input type="text" name="uname"/></td></tr>
    <tr><td>����:</td> <td><input type="text" name="upass"/></td></tr>
    <tr align="center">
    <td colspan="2">
    <input type="submit" value="ע   ��"/>
    &nbsp;&nbsp;
    <input type="reset" value="ȡ   ��"/>
    </td></tr>
    </table>
  </form>
<jsp:include page="student/bottom.jsp"/>
</center>
</body>
</html>
