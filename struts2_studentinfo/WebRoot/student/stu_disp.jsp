<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>��ʾѧ����Ϣ</title>
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
	obj.bgColor=color;//�ú�����Ҫ���ü�¼�еı�����ɫ
}
</script>
</head>
<body background="background.GIF">
<center>
<jsp:include page="top.jsp"/>
    <table width="804" height="57" border="1" bgColor="#CDD8FC">
     <caption align="center">
     <span class="STYLE4">ѧ����Ϣ��</span>
     </caption>
      <tr align="center" bgcolor="#CCFF33">
        <td width="46" height="28" bgcolor="#CCFF33"><span class="STYLE2">ѧ��</span></td>
        <td width="65" bgcolor="#CCFF33"><span class="STYLE2">����</span></td>
        <td width="40" bgcolor="#CCFF33"><span class="STYLE2">�Ա�</span></td>
        <td width="95" bgcolor="#CCFF33"><span class="STYLE2">��������</span></td>
        <td width="82" bgcolor="#CCFF33"><span class="STYLE2">רҵ</span></td>
        <td width="62" bgcolor="#CCFF33"><span class="STYLE2">�ɼ�</span></td>
        <td width="127" bgcolor="#CCFF33"><span class="STYLE2">�绰</span></td>
        <td colspan="4" bgcolor="#CCFF33"><span class="STYLE2">����</span></td>
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
        <td width="47" ><a href="${pageContext.request.contextPath }/student/stu_add.jsp">���</a></td>
        <td width="42"><a href="${pageContext.request.contextPath }/stu_delete?sid=${stu.sid }">ɾ��</a></td>
        <td width="42" ><a href="${pageContext.request.contextPath }/stu_toModify?sid=${stu.sid }">�޸�</a></td>
        <td width="49" ><a href="${pageContext.request.contextPath }/student/stu_query.jsp">��ѯ</a></td>
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
