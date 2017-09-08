<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
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
<form action="" method="post">
  <table width="424" height="57" border="1">
    <caption align="center">
    <font color=red size=5>修改学生信息</font>
            </caption>
    <tr>
      <td>学号:</td>
      <td><input type="text" name="id"/></td>
    </tr>
    <tr>
      <td>姓名:</td>
      <td><input type="text" name="name"/></td>
    </tr>
    <tr>
      <td>性别:</td>
      <td><input type="radio" name="sex" checked value="男"/>
        男
        <input type="radio" name="sex" value="女"/>
        女 </td>
    </tr>
    <tr>
      <td>出生日期:</td>
      <td><input type="text" name="birthday"/><font color=red>默认格式为:*2014/1/2</font></td>
    </tr>
    <tr>
      <td>专业:</td>
      <td><select name="major" id="select">
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
      <td><input type="text" name="score"/></td>
    </tr>
    <tr>
      <td>电话:</td>
      <td><input type="text" name="tel"/></td>
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
