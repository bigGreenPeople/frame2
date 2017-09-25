<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>手机销售系统</title>
</head>
 <link href="css/css.css" rel="stylesheet" type="text/css">
  <script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
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
	
	<br><br>
	
      <div align="center" style="font-size: 14px; font-weight: bold;">
	      订货明细查询
	      <br>
<br></div>

      <table width="89%"  border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolorlight="#FFFFFF" bordercolordark="#819BBC">

        <tr align="center" style="font-size: 14px; font-weight: bold;">
          <td width="25%" height="21">编号</td>
          <td width="24%">商品名称</td>
          <td width="28%">商品价格</td>
          <td width="23%">商品数量</td>
        </tr>  
        <c:forEach items="${order.orderDetailSet }" var="orderDetail">
        <tr  align="center" style="font-size: 12px;">
          <td height="21">${orderDetail.id }</td>
          <td>${orderDetail.goods.goodsName }</td>
          <td><c:if test="${orderDetail.goods.mark==0}">${orderDetail.goods.nowPrice }<input class="money" type="hidden" value="${orderDetail.goods.nowPrice*orderDetail.number }"/></c:if>
            	<c:if test="${orderDetail.goods.mark==1}">${orderDetail.goods.freePrice }<input class="money" type="hidden" value="${orderDetail.goods.freePrice*orderDetail.number }"/></c:if>元</td>
          <td>${orderDetail.number}</td>
        </tr>
        </c:forEach>
      </table>

	   <table width="89%"  border="0" cellspacing="0" cellpadding="0">
         <tr>
           <td height="24"><div align="right">总金额：<span id="numMoney"></span>元</div></td>
         </tr>
       </table>
      </div>
</td>
  </tr>
</table>

<jsp:include page="fg-down.jsp" flush="true"/>
<script type="text/javascript">
	$(function(){
		//总价格
		var numMoney = 0;
		$(".money").each(function(){
			numMoney = numMoney+parseInt($(this).val());
			//alert(parseInt($(this).val()));
		});
		$("#numMoney").text(numMoney);
	});
</script>
</body>
</html>
