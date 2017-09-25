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
	<strong>我的购物车</strong>	<div align="center"><br>         
         
           <c:if test="${fn:length(goodsList)==0}">
           		  您还没有购物！！！
           </c:if>
        </div>
        <c:if test="${fn:length(goodsList)>0}">
        <form method="post" action="index_toCartCheckOut" name="form">
		  <table width="92%"  border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#819BBC" bordercolorlight="#FFFFFF">
          <tr style="font-size: 14xp; font-weight: bold;" >
            <td width="16%" height="28"><div align="center">序号</div></td>
            <td width="23%"><div align="center">商品的名称</div></td>
            <td width="22%"><div align="center">商品价格</div></td>
            <td width="22%"><div align="center">商品数量</div></td>
            <td width="17%"><div align="center">总金额</div></td>
          </tr>
         <c:forEach items="${goodsList }" var="goods">
          <tr style="font-size: 12px;">
            <td height="28"><div align="center">${goods.id }<input name="ids" size="7" type="hidden"  value="${goods.id }" ></div></td>
            <td><div align="center">${goods.goodsName }</div></td>
            <td><div align="center"><c:if test="${goods.mark==0}">${goods.nowPrice }</c:if>
            	<c:if test="${goods.mark==1}">${goods.freePrice }</c:if>
            	</div></td>
            <td class="num" ><div align="center"><input name="nums" size="7" type="text"  value="1" ></div></td>
            <td><div align="center"><span class="money"><c:if test="${goods.mark==0}">${goods.nowPrice }</c:if><c:if test="${goods.mark==1}">${goods.freePrice }</c:if></span>元</div></td>
          </tr>
		</c:forEach>
        </table>
        </form>

<table width="100%" height="52" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr align="center" valign="middle">
		<td height="10">&nbsp;		</td>
        <td width="24%" height="10" colspan="-3" align="left">&nbsp;</td>
		</tr>
      <tr align="center" valign="middle">
        <td height="21" class="tableBorder_B1">&nbsp;</td>
        <td height="21" colspan="-3" align="left" >合计总金额：<br/>￥<span id="numMoney"></span></td>
      </tr>
      <tr align="center" valign="middle">
        <td height="21" colspan="2"> <a href="index_toIndex">继续购物</a> | <a href="javascript:submitt()" onClick="">去收银台结账</a> | <a href="index_cartOut">清空购物车</a> 
        </tr>
</table>
</c:if>
</td>
  </tr>
</table>
<jsp:include page="fg-down.jsp" flush="true"/>
<script type="text/javascript">
	function submitt(){
		$("form").submit();
	}
</script>
<script type="text/javascript">
	
	$(".num").keyup(function(){
		//$("#price").text();
		var price = $(this).prev().text();
		var num = $(this).find("input").val();
		//alert(num);
		$(this).next().find("span").text((price*num));
		
		//总价格
		var numMoney = 0;
		$(".money").each(function(){
			numMoney = numMoney+parseInt($(this).text());
			//alert($(this).text());
		});
		$("#numMoney").text(numMoney);
	});
	$(function(){
		//总价格
		var numMoney = 0;
		$(".money").each(function(){
			numMoney = numMoney+parseInt($(this).text());
			//alert($(this).text());
		});
		$("#numMoney").text(numMoney);
	});
</script>
</body>
</html>
