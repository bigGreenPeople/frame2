<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>手机销售系统</title>
</head>
 <link href="css/css.css" rel="stylesheet" type="text/css"> 
<body>
<jsp:include page="fg-top.jsp" flush="true"/>
<table width="766" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="207" valign="top" bgcolor="#F5F5F5">
    <!--左侧01-->
    <jsp:include page="fg-left.jsp" flush="true"/></td>
    <td width="559" valign="top" bgcolor="#FFFFFF" align="center">
    <!--右侧01-->	
	<jsp:include page="fg-goodSorts.jsp" flush="true"/>	
	商品销售排行 TOP5
	<br><br>
	<c:forEach items="${goodssTen.list }" varStatus="status" var="goods">
        第${status.index+1 }名
		<table width="99%"  border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolorlight="#FFFFFF" bordercolordark="#819BBC">
          <tr>
            <td width="36%" rowspan="4" height="84"><div align="center">
                <input name="pricture" type="image" <c:if test="${goods.pirture!=null}">src="file/${goods.pirture}"</c:if> width="110" height="100">
            </div></td>
            <td width="64%" height="21"><div align="center">${goods.goodsName }</div></td>
          </tr>
          <tr>
            <td height="21"><div align="center">单价：<c:if test="${goods.mark==0}">${goods.nowPrice }</c:if>
                          	<c:if test="${goods.mark==1}">${goods.freePrice }</c:if>元</div></td>
          </tr>
          <tr>
            <td height="21"><div align="center">${goods.introduce}</div></td>
          </tr>
          <tr>
          
            <td height="21" align="center"> 
            <c:if test="${loginMember!=null }">
			<a href="#" onClick="window.open('index_showGoodsInfo?goods.id=${goods.id}','','width=500,height=200');">查看详细内容</a>
			</c:if>
        <c:if test="${loginMember==null }">   登录后才能购买</c:if></td>
          </tr>
        </table><hr/>
        </c:forEach><br>
	</td>
  </tr>
</table>
<jsp:include page="fg-down.jsp" flush="true"/>
</body>
</html>
