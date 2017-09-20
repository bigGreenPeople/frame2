<%@ page contentType="text/html; charset=utf-8" %>
<%@page import="java.sql.*,java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>手机销售系统</title>
</head>
<link href="css/css.css" rel="stylesheet" type="text/css"> 
<script type="text/javascript" language="javascript">
function checkEmpty(memberForm){
for(i=0;i<memberForm.length;i++){
if(memberForm.elements[i].value==""){
alert("表单信息不能为空");
return false;
}
}
//新加入的验证E-mail地址是否正确209-05-25
var vemail=memberForm.email.value;
var regExp=/\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/;
if(!regExp.test(vemail)){
	window.alert("您输入的邮箱地址不正确！");return false;
}
if(document.memberForm.password.value!=document.memberForm.passwordOne.value){
window.alert("您两次输入的密码不一致，请重新输入");
return false;
}
if(isNaN(document.memberForm.age.value)){
window.alert("年龄只能为数字");
return false;
}
}
</script>
<body>
<jsp:include page="fg-top.jsp" flush="true"/>
<table width="766" border="0" align="center" cellpadding="0" cellspacing="0" bordercolor="#000000">
  <tr>
    <td bgcolor="#F5F5F5" align="center">
<img src="image/fg1.jpg" width="752" height="39">


<form action="${pageContext.request.contextPath }/member_updataMember" method="post"  onsubmit="return checkEmpty(memberForm)">
<table width="298"  border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="105" height="35">
          <div align="right">会员名称：</div></td>
        <td width="187"><div align="center">
          <input type="hidden" name="name" value="${loginMember.name }">${loginMember.name }
        </div></td>
      </tr>
       <tr>
        <td height="35">
          <div align="right">原来的密码：</div></td>
        <td><div align="center">
           <input type="hidden" name="result" value="${loginMember.result }">
            <input type="hidden" name="question" value="${loginMember.question }">
         <input type="hidden" name="id" value="${loginMember.id }">
          <input type="password" name="oldPassword">
        </div></td>
      </tr>
      <tr>
        <td height="35">
          <div align="right">会员密码：</div></td>
        <td><div align="center">
          <input type="password" name="password">
        </div></td>
      </tr>
      <tr>
        <td height="35">
          <div align="right">密码确认：</div></td>
        <td><div align="center">
          <input type="password" name="passwordOne">
        </div></td>
      </tr>
      <tr>
        <td height="35">
          <div align="right">真实姓名：</div></td>
        <td><div align="center">
          <input type="text" name="reallyName" value="${loginMember.reallyName }">
        </div></td>
      </tr>
      <tr>
        <td height="35">
          <div align="right">年龄：</div></td>
        <td><div align="center">
          <input type="text" name="age" value="${loginMember.age }">
        </div></td>
      </tr>
      <tr>
        <td height="35">
          <div align="right">职业：</div></td>
        <td><div align="center">
          <input type="text" name="profession" value="${loginMember.profession }">
        </div></td>
      </tr>
      <tr>
        <td height="35">
          <div align="right">Email地址：</div></td>
        <td><div align="center">
          <input name="email" type="text"  value="${loginMember.email }">
        </div></td>
      </tr>
    </table>
    <br>
<input type="image" class="input1"  src="image/save.jpg" width="51" height="20">
&nbsp;&nbsp;
<a href="#" onClick="javascript:memberForm.reset()"><img src="image/clear.gif"></a>
&nbsp;&nbsp;
<a href="#" onClick="javasrcipt:history.go(-1)"><img src="image/back.gif"></a>
</form>
  <p>&nbsp;  </p>   </td>
  </tr>
</table>
<jsp:include page="fg-down.jsp" flush="true"/>
</body>
</html>
