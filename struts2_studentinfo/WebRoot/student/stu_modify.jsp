<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<title>修改学生信息</title>
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
<form action="${pageContext.request.contextPath }/stu_modify" method="post">
  <table width="424" height="57" border="1">
    <caption align="center">
    <font color=red size=5>修改学生信息</font>
            </caption>
    <tr>
      <td>学号:</td>
      <td><input type="text" name="sid" value="${stu.sid }"/></td>
    </tr>
    <tr>
      <td>姓名:</td>
      <td><input type="text" name="sname" value="${stu.sname }"/></td>
    </tr>
    <tr>
      <td>性别:</td>
      
      <td>
      
      <input type="radio" name="ssex" <c:if test="${stu.ssex=='男' }">checked</c:if> value="男"/>
        男
        <input type="radio" name="ssex" <c:if test="${stu.ssex=='女' }">checked</c:if> value="女"/>
        女 </td>
    </tr>
    <tr>
      <td>出生日期:</td>
      <td><input type="text" name="sbirthday" value="${stu.sbirthday }"/><font color=red>默认格式为:*2014-01-02</font></td>
    </tr>
    <tr>
      <td>专业:</td>
      <td><select name="smajor" id="select">
          <option >--请选择专业--</option>
          <option value="工商企业管理">工商企业管理</option>
          <option value="会计学">会计学</option>
          <option value="计算机软件技术">计算机软件技术</option>
          <option value="计算机网络技术">计算机网络技术</option>
          <option value="商务英语">商务英语</option>
          <option value="应用电子技术">应用电子技术</option>
          <option value="数控技术">数控技术</option>
          <option value="机电一体化">机电一体化</option>
          <option value="应用数学">应用数学</option>
          <option value="通信工程">通信工程</option>
          <option value="应用化学">应用化学</option>
          <option value="生物工程">生物工程</option>
      </select></td>
    </tr>
    <tr>
      <td>成绩:</td>
      <td><input type="text" name="sscore" value="${stu.sscore }"/></td>
    </tr>
    <tr>
      <td>电话:</td>
      <td><input type="text" name="stel" value="${stu.stel }"/></td>
    </tr>
    <tr align="center">
      <td colspan="2"><input type="submit" value="修   改"/>
        &nbsp;&nbsp;
        <input type="reset" value="取   消"/>
      </td>
    </tr>
  </table>
</form>
<jsp:include page="bottom.jsp"/>
</center>
</body>
</html>
