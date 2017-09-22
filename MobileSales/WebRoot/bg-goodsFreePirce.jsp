<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.sql.*,java.util.*"%>
<script language="javascript">
function checkEmpty(form){
for(i=0;i<form.length;i++){
if(form.elements[i].value==""){
alert("表单信息不能为空");
return false;
}
}
if(isNaN(document.form.free.value)){
window.alert("价格只能为数字");
return false;
}
if(document.form.free.value==document.form.now.value){
window.alert("您输入特价商品的价格应该与原来的价格是等价的，请重新输入！！！");
return false;
}
if(document.form.free.value-document.form.now.value>0){


window.alert("您输入特价商品的价格应该比原来的价格高，请重新输入！！！");
return false;
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
            <td><div align="center"><strong>设置特价商品</strong></div></td>
          </tr>
        </table>
        <br>
		
		 <form name="form" method="post" action="${pageContext.request.contextPath }/goods_setingGoods" onSubmit="return checkEmpty(form)">
        <table style="font-size: 14px;" width="90%" height="233"  border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#CCCCCC">
          <tr>
            <td width="20%" height="26">&nbsp;&nbsp;所属大类别<input name="goods.id" type="hidden" value="${goods.id}"></td>
            <td width="31%" bgcolor="#FFFFFF">&nbsp;&nbsp;${goods.smallType.bigType.bigName }</td>
            <td width="20%">&nbsp;&nbsp;所属于小类别</td>
            <td width="31%" bgcolor="#FFFFFF">&nbsp;&nbsp;${goods.smallType.smallName }</td>
          </tr>
          <tr>
            <td height="26">&nbsp;&nbsp;商品名称</td>
            <td bgcolor="#FFFFFF">&nbsp;&nbsp;${goods.goodsName}</td>
            <td>&nbsp;&nbsp;生产厂商</td>
            <td bgcolor="#FFFFFF">&nbsp;&nbsp;${goods.goodsFrom}</td>
          </tr>
          <tr>
            <td height="26">&nbsp;&nbsp;商品定价</td>
            <td bgcolor="#FFFFFF">&nbsp;&nbsp;
            <input name="goods.nowPrice" type="hidden" value="${goods.nowPrice}">${goods.nowPrice}元</td>
            <td>&nbsp;&nbsp;是否特价</td>
            <td bgcolor="#FFFFFF">&nbsp;&nbsp;
                     <c:if test="${goods.mark==0}">否</c:if>
	          	<c:if test="${goods.mark==1}">是</c:if>
            </td>
          </tr>
          <tr>
            <td height="23">&nbsp;&nbsp;商品简介</td>
            <td bgcolor="#FFFFFF" >&nbsp;&nbsp;${goods.introduce}</td>
		    <td>&nbsp;&nbsp;特价价格</td>
            <td bgcolor="#FFFFFF">
            &nbsp;
              <input name="goods.freePrice" type="text" size="12" value="${goods.freePrice}" />
            <input type="submit" name="Submit" value="提交">       </td>
          </tr>
          <tr>
            <td height="79">&nbsp;&nbsp;商品图片</td>
            <td colspan="3" bgcolor="#FFFFFF">&nbsp;&nbsp;
            <img <c:if test="${goods.pirture!=null}">src="file/${goods.pirture}"</c:if>
             width="140" height="126"/></td>
          </tr>
        </table>  </form>              
        <table width="90%"  border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="87%" height="29" align="right">&nbsp;&nbsp;&nbsp;</td>
            <td width="13%"> <a href="javascript:history.back();">返回</a></td>
          </tr>
        </table>
    </td>
  </tr>
</table>
<jsp:include page="bg-down.jsp" flush="true" />
</body>
</html>
