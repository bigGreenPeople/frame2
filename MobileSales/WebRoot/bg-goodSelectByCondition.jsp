<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.sql.*,java.util.*"%>
 <script Language="JavaScript">
 function deleteType(date) {
  if(confirm("确定要删除吗？")){
    window.location="bigTypeAction.do?action=3&id="+date;
	}
  }
 </script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>手机销售系统</title>

</head>
 <link href="css/css.css" rel="stylesheet" type="text/css">
 <script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<body>

<jsp:include page="bg-up.jsp" flush="true"/>
<table width="788" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="170"  valign="top"><jsp:include page="bg-left.jsp" flush="true" /></td>
    <td width="618" align="center" valign="top" bgcolor="#FFFFFF"> <br>
	
        <table width="610" height="25" border="0" cellpadding="0" cellspacing="0" background="image/bg_02.jpg">
          <tr>
            <td><div align="center"><strong>商品查询</strong></div></td>
          </tr>
        </table>
        <br>
		  <table width="90%"   border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#CCCCCC">
        <tr>
          <td width="14%" height="25"><div style="font-size: 14px;" align="center">数据编号</div></td>
          <td width="19%"><div style="font-size: 14px;" align="center">商品名称</div></td>
          <td width="14%"><div style="font-size: 14px;" align="center">大类别</div></td>
          <td width="14%"><div style="font-size: 14px;" align="center">小类别</div></td>
          <td width="14%"><div style="font-size: 14px;" align="center">是否特价</div></td>
          <td width="25%"><div style="font-size: 14px;" align="center">操作</div></td>
        </tr>
		<c:forEach items="${goodss.list }" var="goods">
	        <tr bgcolor="#FFFFFF">
	          <td height="30"><div align="center">${goods.id }</div></td>
	          <td><div align="center">${goods.goodsName }</div></td>
	
	          <td><div align="center">${goods.smallType.bigType.bigName }</div></td>
	
	          <td><div align="center">${goods.smallType.smallName }</div></td>
	          <td><div align="center">
	          	<c:if test="${goods.mark==0}">否</c:if>
	          	<c:if test="${goods.mark==1}">是</c:if>
	          </div></td>
	          <td><div align="center"><a href="${pageContext.request.contextPath }/goods_showGoods?goods.id=${goods.id }">详细信息</a>&nbsp;&nbsp;
			 
			 <a href="goods_deleteGoods?goods.id=${goods.id}">删除</a>
			 
			  </div></td>
	          </tr>
          </c:forEach>
      </table>
	  <br>
	  <table width="90%"  border="0" align="center" cellpadding="0" cellspacing="0">
        <tr align="center">
          <td style="font-size: 12px;" width="13%">共为${goodss.totalPage }页</td>
          <td  style="font-size: 12px;" width="16%">共有${goodss.totalCount }条记录</td>
          <td style="font-size: 12px;" width="14%">当前为第${goodss.currentPage }页</td>
          <td style="font-size: 12px;" width="19%">
       
        <c:if test="${1!=goodss.currentPage}">
				<li class="current"><a href="javascript:up('${goodss.currentPage-1}')">上一页</a></li>
			</c:if>
        </td>
      
          <td width="18%">
            
              <c:if test="${goodss.totalPage!=goodss.currentPage}">
				<li class="current"><a href="javascript:down('${goodss.currentPage+1}')">下一页</a></li>
			</c:if>
       	</td>

          <td width="20%">
            <div align="right"><img src="image/bg-add.gif" width="9" height="9"><a href="${pageContext.request.contextPath}/goods_toAddGoods">&nbsp;添加商品&nbsp;</a></div></td>
		</tr>
      </table>

<P align="center"></P>
	<form action="" method="post">
		<input type="hidden" name="goodsCondition.goodsName" value="${goodsCondition.goodsName }"/>
		<input type="hidden" name="goodsCondition.bigType_id" value="${goodsCondition.bigType_id }"/>
		<input type="hidden" name="goodsCondition.smallType_id" value="${goodsCondition.smallType_id }"/>
		<input type="hidden" name="goodsCondition.mark" value="${goodsCondition.mark }"/>
	</form>
    </td>
  </tr>
</table>
<jsp:include page="bg-down.jsp" flush="true" />
</body>
<script type="text/javascript">
	function down(date){
		//alert(date);
	  	$("form").attr("action","goods_findGoods?currentPage="+date);
	  	$("form").submit();
	  }
	  
	  function up(date){
	  	$("form").attr("action","goods_findGoods?currentPage="+date);
	  	$("form").submit();
	  }
</script>
</html>
