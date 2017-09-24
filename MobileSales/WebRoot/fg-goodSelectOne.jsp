<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.sql.*,java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="managerGoods/css/css.css">
<title>手机销售系统</title>
<style type="text/css">
<!--
body {
	background-color: #fafafa;
}

td {
	font-size: 9pt;	color: #000000;
}
.style1 {
	color: #FF9900;
	font-weight: bold;
}

-->
</style></head>

<body>
<form name="form" method="post" action="index_addCart">
<div align="center">
  <p class="style1">查看商品清单</p>
</div>
<table width="500"  border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolorlight="#FFFFFF" bordercolordark="#819BBC">
  <tr>
    <td width="36%" rowspan="4" height="120"><div align="center">
        <input name="pricture" type="image" src="goodsPicture/huawei/1492255388853.jpg" width="110" height="100">
    </div></td>
    <td width="64%" height="30"><div align="center">
      <table width="71%" height="20"  border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td>货品名称：${goods.goodsName } <input type="hidden" name="goods.id" value="#" /></td>
        </tr>
      </table>
    </div></td>
  </tr>
  <tr>
    <td height="30"><div align="center">
        <table width="71%"  border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td>
        <c:if test="${goods.mark==1 }">
特&nbsp;&nbsp;&nbsp;&nbsp;价：${goods.freePrice }元<input  type="hidden" name="goods.nowPrice" value="${goods.freePrice }"/>

现&nbsp;&nbsp;&nbsp;&nbsp;价：${goods.nowPrice }元<input type="hidden" name="price" value="${goods.nowPrice }"/>
</c:if>
<c:if test="${goods.mark==0 }">
 现&nbsp;&nbsp;&nbsp;&nbsp;价：${goods.nowPrice }元<input type="hidden" name="goods.nowPrice" value="${goods.nowPrice }"/>
 </c:if>
</td>
      </tr>
    </table>
</div></td>
  </tr>
  <tr>
    <td height="30"><div align="center">
      <table width="71%"  border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td>简&nbsp;&nbsp;&nbsp;&nbsp;介：${goods.introduce }</td>
        </tr>
      </table>
    </div></td>
  </tr>
  <tr align="center">
    <td height="30">
	<img src="image/1.jpg" onClick="window.close()">
	&nbsp;&nbsp;<input type="image" src="image/2.jpg" name="Submit" value="放入购物车"></td>
  </tr>
</table>
</form>
</body>
</html>
