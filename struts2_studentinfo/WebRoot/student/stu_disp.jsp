<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>显示学生信息</title>
<style type="text/css">
<!--
.STYLE2 {color: #FF0000}
.STYLE4 {
	color: #FF0000;
	font-size: 24px;
	font-weight: bold;
}
body {
	background-image: url(background.GIF);
}
-->
</style>
<style type="text/css">
<!--
body {
	margin-top: 0px;
	margin-bottom: 0px;
}
-->
</style>
<script language="javascript">
function changeColor(obj,color){
	obj.bgColor=color;//该函数主要设置记录行的背景颜色
}
</script>
</head>
<body background="background.GIF">
<center>
<jsp:include page="top.jsp"/>
    <table width="804" height="57" border="1" bgColor="#CDD8FC">
     <caption align="center">
     <span class="STYLE4">学生信息表</span>
     </caption>
      <tr align="center" bgcolor="#CCFF33">
        <td width="46" height="28" bgcolor="#CCFF33"><span class="STYLE2">学号</span></td>
        <td width="65" bgcolor="#CCFF33"><span class="STYLE2">姓名</span></td>
        <td width="40" bgcolor="#CCFF33"><span class="STYLE2">性别</span></td>
        <td width="95" bgcolor="#CCFF33"><span class="STYLE2">出生日期</span></td>
        <td width="82" bgcolor="#CCFF33"><span class="STYLE2">专业</span></td>
        <td width="62" bgcolor="#CCFF33"><span class="STYLE2">成绩</span></td>
        <td width="127" bgcolor="#CCFF33"><span class="STYLE2">电话</span></td>
        <td colspan="4" bgcolor="#CCFF33"><span class="STYLE2">操作</span></td>
      </tr>
     
       <c:forEach items="${list }" var="stu">
        <tr   onMouseOver="changeColor(this,'white')"
  onMouseOut="changeColor(this,'#CDD8FC')">
        <td>${stu.sid }</td>
        <td >${stu.sname}</td>
        <td >${stu.ssex }</td>
        <td >${stu.sbirthday }</td>
        <td >${stu.smajor }</td>
        <td >${stu.sscore }</td>
        <td >${stu.stel }</td>
        <td width="47" ><a href="${pageContext.request.contextPath }/student/stu_add.jsp">添加</a></td>
        <td width="42"><a href="${pageContext.request.contextPath }/stu_delete?sid=${stu.sid }">删除</a></td>
        <td width="42" ><a href="${pageContext.request.contextPath }/stu_toModify?sid=${stu.sid }">修改</a></td>
        <td width="49" ><a href="${pageContext.request.contextPath }/student/stu_query.jsp">查询</a></td>
        </tr>
       </c:forEach>
      
    </table>
 <br>
  <br>
   <br>
   <br>
   <br>
    <br>
     <br>
     <jsp:include page="bottom.jsp"/>
</center>
</body>
</html>
