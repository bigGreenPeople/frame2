<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	
	<table width="546" height="42" border="0" align="center" cellpadding="0" cellspacing="0" background="image/fg_right01.jpg">
  <tr>
    <td>&nbsp;	</td>
    </tr>
</table>
			 <br> 
			 <c:forEach items="${newGoodss.list}" var="goods">
			 <table width="99%" height="100"  border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolorlight="#FFFFFF" bordercolordark="#819BBC">

              <tr>
                <td width="36%" rowspan="4" height="120"><div align="center">
                  <input name="pricture" type="image" <c:if test="${goods.pirture!=null}">src="file/${goods.pirture}"</c:if> width="140" height="110">
                </div></td>
                <td width="64%" height="30"><div align="center">${goods.goodsName }</div></td>
              </tr>
              <tr>
                <td height="30"><div align="center">单价：<c:if test="${goods.mark==0}">${goods.nowPrice }</c:if>
                          	<c:if test="${goods.mark==1}">${goods.freePrice }</c:if>元</div></td>
              </tr>
              <tr>
                <td height="30"><div align="center">${goods.introduce }</div></td>
              </tr>
              <tr>
                <td height="30"><div align="center"> 
                <c:if test="${loginMember!=null }">
               	<a href="#" onClick="window.open('index_showGoodsInfo?goods.id=${goods.id}','','width=600,height=400');">查看详细内容</a>				
               </c:if>
               <c:if test="${loginMember==null }">
			登录后才能购买</c:if>
               </td>
              </tr>
            </table>
            <hr/>
            </c:forEach>
			<br>
             <table width="96%"  border="0" align="center" cellpadding="0" cellspacing="0">
    <tr align="center">
          <td style="font-size: 12px;" width="13%">共为${newGoodss.totalPage }页</td>
          <td  style="font-size: 12px;" width="16%">共有${newGoodss.totalCount }条记录</td>
          <td style="font-size: 12px;" width="14%">当前为第${newGoodss.currentPage }页</td>
          <td style="font-size: 12px;" width="19%">
        <c:if test="${1<newGoodss.currentPage}">
				<li class="current"><a href='${pageContext.request.contextPath}/index_toNewGoods?currentPage=${newGoodss.currentPage-1}'>上一页</a></li>
			</c:if>
        </td>
      
          <td width="18%">
              <c:if test="${newGoodss.totalPage>newGoodss.currentPage}">
				<li class="current"><a href='${pageContext.request.contextPath}/index_toNewGoods?currentPage=${newGoodss.currentPage+1}'>下一页</a></li>
			</c:if>
       	</td>

		</tr>
 </table>
	</td>
  </tr>
</table>
<jsp:include page="fg-down.jsp" flush="true"/>
</body>
</html>
