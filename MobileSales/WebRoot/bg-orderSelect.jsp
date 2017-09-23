<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.sql.*,java.util.*"%>
 <script Language="JavaScript">
 function deleteOrder(date) {
  if(confirm("确定要删除吗？")){
    window.location="order_deleteOrder?id="+date;
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
    <td width="618" align="center" valign="top" bgcolor="#FFFFFF">
	
	
	
<br>
	

	<table width="610" height="25" border="0" cellpadding="0" cellspacing="0" background="image/bg_02.jpg">
      <tr>
        <td><div align="center"><strong>订单的查询</strong></div></td>
      </tr>
    </table>	<br>
	    <table width="96%"  border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="CCCCCC">

	    <tr bgcolor="#DCDCDC" style="font-size: 14px;">
          <td width="15%" height="25"><div align="center">编号</div></td>
          <td width="14%"><div align="center">真实姓名</div></td>

         <td width="16%"><div align="center">是否出货</div></td>
        <td width="26%"><div align="center">订货时间</div></td>
   <td width="29%"><div align="center">操作</div></td>
        </tr>
    	<c:forEach items="${orders.list }" var="order">
        <tr align="center" bgcolor="#FFFFFF" style="font-size: 12px;">
          <td height="25">${order.id}</td>
          <td>${order.member.reallyName }</td>

		  <td>
		  <c:if test="${order.sign==0}">否</c:if>
		   <c:if test="${order.sign==1}">是</c:if>
         </td>
		  <td>${order.creaTime }</td>
        <td><a href="order_showOrderInfo?id=${order.id}">详细信息</a>
                             &nbsp;&nbsp;
	  		 <c:if test="${order.sign==1}"> 已出</c:if>
		  <!-- <a href="orderAction.do?action=1&number=">出货</a> -->
		 <c:if test="${order.sign==0}"> <a href="order_sendGoods?id=${order.id}">出货</a></c:if>
		 &nbsp;&nbsp;
		 <a href="javascript:deleteOrder('${order.id}')">删除</a></td>
        </tr>
  </c:forEach>
      </table><br>

  <table width="96%"  border="0" align="center" cellpadding="0" cellspacing="0">
    <tr align="center">
          <td style="font-size: 12px;" width="13%">共为${orders.totalPage }页</td>
          <td  style="font-size: 12px;" width="16%">共有${orders.totalCount }条记录</td>
          <td style="font-size: 12px;" width="14%">当前为第${orders.currentPage }页</td>
          <td style="font-size: 12px;" width="19%">
        <c:if test="${1!=orders.currentPage}">
				<li class="current"><a href='${pageContext.request.contextPath}/order_findAllOrder?currentPage=${orders.currentPage-1}'>上一页</a></li>
			</c:if>
        </td>
      
          <td width="18%">
              <c:if test="${orders.totalPage!=orders.currentPage}">
				<li class="current"><a href='${pageContext.request.contextPath}/order_findAllOrder?currentPage=${orders.currentPage+1}'>下一页</a></li>
			</c:if>
       	</td>

		</tr>
 </table>

</td>
  </tr>
</table><jsp:include page="bg-down.jsp" flush="true" />

</body>
</html>
