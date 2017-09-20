<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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

 <!-- <p><strong>不存在此会员名称,请重新输入！！！</strong></p>
 <meta http-equiv="refresh" content="3;URL=fg-One.jsp"> -->

  <p><strong>输入答案</strong></p>
  <form name="form" method="post">
    <table width="298"  border="0" cellspacing="0" cellpadding="0" bordercolor="#FFFFFF" bordercolordark="#819BBC" bordercolorlight="#FFFFFF">
      <tr>
        <td width="105" height="35">
          <div align="right">问题:</div></td>
        <td width="187"><div align="left">
            <input type="hidden" id="name" name="name" value="${member.name }">
            <%-- <input type="hidden" name="question" value="${member.question }"> --%>
            ${member.question }
        </div></td>
      </tr>
       <tr>
        <td width="200" height="35">
          <div align="right">答案:</div></td>
        <td width="187">
          <div align="left">
            <input type="text" name="result">
          </div></td>
          <td width="200">
          	<span style="font-size: 12px; color: red;" id="msg"></span>
          </td>
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
//当表单提交前检测
		$("form").submit(function(){
			var result = $.trim($(":text").val());
			//alert("sda");
			if(result.length==0){
				alert("答案不能为空");
			}
			
			var name = $("#name").val();
			
			//alert(name);
				$.ajax({
					url: "${pageContext.request.contextPath }/member_toUpPass",
					type: "post",
					data: "result="+result+"&name="+name,
					dataType: "html",
					success: function(html){
					//alert(html);
						if(html!="回答错误!"){
							location.href="${pageContext.request.contextPath }/member_toUpPass2?id="+html;
						}else{
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
