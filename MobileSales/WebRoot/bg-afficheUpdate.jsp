<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script language="javascript">
function checkEmpty(form){
for(i=0;i<form.length;i++){
if(form.elements[i].value==""){
alert("表单信息不能为空");
return false;
}
}
}
</script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>手机销售系统</title>
</head>
<link href="css/css.css" rel="stylesheet" type="text/css">
<body>

<jsp:include page="bg-up.jsp" flush="true"/>
<table width="788" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="170"  valign="top"><jsp:include page="bg-left.jsp" flush="true" /></td>
    <td width="618" align="center" valign="top" bgcolor="#FFFFFF"> <br>
	
        <table width="610" height="25" border="0" cellpadding="0" cellspacing="0" background="image/bg_02.jpg">
          <tr>
            <td><div align="center"><strong>修改公告信息</strong></div></td>
          </tr>
        </table>
        <br>
				 
		 <form action="${pageContext.request.contextPath}/affiche_updateAffiche" onsubmit="return checkEmpty(afficheForm)">
		     <table width="90%" height="243"  border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#CCCCCC">
          <tr>
            <td width="23%" height="30"><div align="center">公告标题</div></td>
            <td width="77%" bgcolor="#FFFFFF">
              <input name="id" type="hidden"  value="${affiche.id }"><input name="name" type="text" size="55" value="${affiche.name }"></td>
          </tr>
          <tr>
            <td height="208"><div align="center">公告内容</div>              </td>
            <td bgcolor="#FFFFFF">
              <textarea name="content" cols="45" rows="13" class="textarea">${affiche.content }</textarea></td>
          </tr>
        </table><br>  
      <input type="image" class="input1"  src="image/save.jpg" width="51" height="20">
&nbsp;&nbsp;
      <a href="#" onClick="javascript:afficheForm.reset()"><img src="image/clear.gif"></a>
&nbsp;&nbsp;
      <a href="#" onClick="javasrcipt:history.go(-1)"><img src="image/back.gif"></a>
</form>
		
		</table>	
<jsp:include page="bg-down.jsp" flush="true" />






</body>
</html>
