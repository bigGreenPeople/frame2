<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>�򵥵�ѧ����Ϣ����ϵͳ</title>
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
  <h2><font color=red>��ѧ����Ϣ����ϵͳ</font></h2>
  <form action="${pageContext.request.contextPath }/user_login" method="post">
  �û���:<input type="text" name="uname"/><br/>
  ��&nbsp;&nbsp;��:<input type="password"  name="upass"/>
  <br/>
  <input type="submit" value="��  ¼"/>&nbsp;
  <input type="reset"  value="ȡ  ��"/>
  <br/>  <br/>  <br/>
  <a href="register.jsp">�û�ע��</a>
  &nbsp;&nbsp;
  <a href="reback.jsp">�һ�����</a>
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
