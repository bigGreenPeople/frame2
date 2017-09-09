<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>查询学生信息</title>
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
<jsp:include page="top.jsp"/>
<form action="${pageContext.request.contextPath }/stu_findStuById" method="post">
    <table width="404" height="57" border="0">
     <caption align="center">
     <font color=red size=5>查询学生信息</font>
     </caption>
    <tr><td>请输入要查询的学号:</td>
    <td><input type="text" name="sid"/></td>
     <td><input type="submit"  value="查询"/></td>
    </tr>
    </table>
    </form>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
<jsp:include page="bottom.jsp"/>
</center>
</body>
</html>
