<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <td width="207" bgcolor="#F5F5F5">
    <!--左侧01-->
    <jsp:include page="fg-left.jsp" flush="true"/></td>
    <td width="559" valign="top" bgcolor="#FFFFFF" align="center">
    <!--右侧01-->	
	<jsp:include page="fg-goodSorts.jsp" flush="true"/>	
	
	第${goodsNumId }名
	
	<br><br><br>
		<table width="99%"  border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolorlight="#FFFFFF" bordercolordark="#819BBC">
          <tr>
            <td width="36%" rowspan="5" height="120"><div align="center">
                <input name="pricture" type="image" <c:if test="${goods.pirture!=null}">src="file/${goods.pirture}"</c:if> width="140" height="126">
            </div></td>
            <td width="64%" height="30"><div align="center">${goods.goodsName }</div></td>
          </tr>

          <tr>
            <td height="30"><div align="center">
              特价：${goods.freePrice }元
             现价：<c:if test="${goods.mark==0}">
             	${goods.nowPrice }
             </c:if>
             <c:if test="${goods.mark==1}">
             	${goods.freePrice }
             </c:if>
             元
            </div></td>
          </tr>
          <tr>
            <td height="30"><div align="center">${goods.introduce}</div></td>
          </tr>
          <tr align="center">
            <td height="30">
              <c:if test="${loginMember!=null }">
               	<a href="#" onClick="window.open('index_showGoodsInfo?goods.id=${goods.id}','','width=600,height=400');">查看详细内容</a>				
               </c:if>
               <c:if test="${loginMember==null }">
			登录后才能购买</c:if>
            </td>
          </tr>
        </table>
	</td>
  </tr>
</table>
<jsp:include page="fg-down.jsp" flush="true"/>
</body>
</html>