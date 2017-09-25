<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.sql.*,java.util.*"%>
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
    <td width="559" valign="top" bgcolor="#FFFFFF">
    <!--右侧01-->	
	<jsp:include page="fg-goodSorts.jsp" flush="true"/>	
    <div align="center">
        <br>
        <img src="image/fg_right02.jpg">
    </div>
    <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolorlight="#FFFFFF" bordercolordark="#819BBC">
    	<c:forEach items="${markGoodss.list}" var="goods">
        <tr> 
            <td valign="top">
            <table width="80%" height="136" border="1" align="center" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#999999">
              <tr>
                <td width="33%" height="80" rowspan="5" bgcolor="#FFFFFF"><input name="pricture" type="image" <c:if test="${goods.pirture!=null}">src="file/${goods.pirture}"</c:if> width="140" height="126"></td>
                <td width="67%" height="20" bgcolor="#FFFFFF"><div align="center">${goods.goodsName}</div></td>
              </tr>
              <tr>
                <td height="20" bgcolor="#FFFFFF"><div align="center" style="text-decoration:line-through;color:#910402">原价：${goods.nowPrice }元</div></td>
              </tr>
              <tr>
                <td height="20" bgcolor="#FFFFFF"><div align="center"><font color="#F14D83">现价：${goods.freePrice }元</font></div></td>
              </tr>
              <tr>
                <td height="20" bgcolor="#FFFFFF"><div align="center">${goods.introduce}</div></td>
              </tr>
              <tr>
                <td height="13" bgcolor="#FFFFFF"><div align="center" class="linkBlack"><c:if test="${loginMember!=null }">
               	<a href="#" onClick="window.open('index_showGoodsInfo?goods.id=${goods.id}','','width=600,height=400');">查看详细内容</a>				
               </c:if>
               <c:if test="${loginMember==null }">
			登录后才能购买</c:if></td>
              </tr>
            </table></td>
        </tr>
        </c:forEach>
</table>
<div align="center">
    <img src="image/fg_right01.jpg">
</div>
<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td height="215" valign="top">
        <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td><table width="99%"  border="0" align="center" cellpadding="0" cellspacing="0" bordercolor="#CCCCCC"   >
                <c:forEach items="${newGoodss.list}" var="goods">
                  <tr>
                    <td height="150" bordercolor="#666666" >
                      <table width="96%"  border="1" align="center" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#CCCCCC" >
                        <tr>
                          <td width="36%" rowspan="4" bgcolor="#FFFFFF"><div align="center">
                              <input name="pricture" type="image" <c:if test="${goods.pirture!=null}">src="file/${goods.pirture}"</c:if> width="110" height="100">
                          </div></td>
                          <td width="64%" bgcolor="#FFFFFF"><div align="center">${goods.goodsName}</div></td>
                        </tr>
                        <tr>
                          <td bgcolor="#FFFFFF"><div align="center"><font color="#F14D83">单价：<c:if test="${goods.mark==0}">${goods.nowPrice }</c:if>
                          	<c:if test="${goods.mark==1}">${goods.freePrice }</c:if>元</font></div></td>
                        </tr>
                        <tr>
                          <td bgcolor="#FFFFFF"><div align="center">${goods.introduce}</div></td>
                        </tr>
                        <tr>
                          <td  bgcolor="#FFFFFF" class="linkBlack"  align="center">
                             <c:if test="${loginMember!=null }">
               	<a href="#" onClick="window.open('index_showGoodsInfo?goods.id=${goods.id}','','width=600,height=400');">查看详细内容</a>				
               </c:if>
               <c:if test="${loginMember==null }">
			登录后才能购买</c:if></td>
                      
                        </tr>
                    </table></td>
                  </tr> 
                  </c:forEach>
                </table></td>
              </tr>
            </table>
			</td>
			 
		       
          </tr>
</table>

</td>
  </tr>
</table>

	<jsp:include page="fg-down.jsp" flush="true"/>

</body>
</html>
