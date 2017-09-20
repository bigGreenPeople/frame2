<%@ page contentType="text/html; charset=gb2312" %>
<%@page import="java.sql.*,java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<title>手机销售系统</title>
</head>
 <link href="css/css.css" rel="stylesheet" type="text/css"> 

<body>
<jsp:include page="fg-top.jsp" flush="true"/>
<table width="766" border="0" align="center" cellpadding="0" cellspacing="0" bordercolor="#000000">
  <tr>
    <td bgcolor="#FFFFFF" align="center">
<img src="image/fg2.jpg" width="752" height="45">

   <p><strong>输入会员账号</strong></p>
  <form name="form" method="post" >
  <table width="400"  border="0" cellspacing="0" cellpadding="0" bordercolor="#FFFFFF" bordercolordark="#819BBC" bordercolorlight="#FFFFFF">
      <tr>
        <td width="105" height="35" bgcolor="#FFFFFF">
          <div align="right">会员账号:</div></td>
        <td width="187"><input type="text" name="name">
        </td>
        <td ><span id="msg"></span></td>
      </tr>
    </table>
    <br>
     <input type="image" class="input1"  src="image/save.jpg" width="51" height="20">
&nbsp;&nbsp;
      <a href="#" onClick="javascript:form.reset()"><img src="image/clear.gif"></a>
&nbsp;&nbsp;
      <a href="#" onClick="javasrcipt:history.go(-1)"><img src="image/back.gif"></a>
  </form>

   </td>
  </tr>
</table>
<jsp:include page="fg-down.jsp" flush="true"/>
</body>
<script type="text/javascript" language="javascript">
function checkEmpty(form){
	
	var form1 = $(form.elements[0]);
		if(form1.val()==""){
		alert("表单信息不能为空");
		return false;
		}
		
		//alert(flag);
		//return false;
		return findByName()
}

//当表单提交前检测
		$("form").submit(function(){
			var username = $.trim($(":text").val());
			//alert("sda");
			if(username.length==0){
				alert("用户名不能为空");
			}
				$.ajax({
					url: "${pageContext.request.contextPath }/member_findMemberByName",
					type: "post",
					data: "name="+username,
					dataType: "html",
					success: function(html){
					//alert(html);
						if(html=="ok"){
							$("#msg").html("");
							location.href="${pageContext.request.contextPath }/member_toQuestion?name="+username;
						}else{
							flag=false;
							$("#msg").html(html);
						}
					   
					 },
					error:function (XMLHttpRequest, textStatus, errorThrown) {
					    // 通常 textStatus 和 errorThrown 之中
					    // 只有一个会包含信息
					   // alert(XMLHttpRequest);
					   alert("服务器未响应!");
					}
				});
			return false;
			
		});
</script>
</html>
