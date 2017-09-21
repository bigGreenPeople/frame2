<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.sql.*,java.util.*"%>
 <script Language="JavaScript">
 function deleteType(date) {
  if(confirm("确定要删除吗？")){
    window.location="${pageContext.request.contextPath}/type_deleteBigType?bigType.id="+date;
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
            <td><div align="center"><strong>商品大类别查询</strong></div></td>
          </tr>
        </table>
        <br>
	  <table width="90%"  border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#CCCCCC">
        <tr>
          <td width="14%" height="25"><div align="center">数据编号</div></td>
          <td width="28%"><div align="center">大类别名称</div></td>
          <td width="28%"><div align="center">创建时间</div></td>
          <td width="30%"><div align="center">操作</div></td>
        </tr>
		<c:forEach items="${bigTypes.list }" var="bigType">
	        <tr bgcolor="#FFFFFF">
	          <td height="30"><div align="center">${bigType.id}</div></td>
	          <td><div align="center">${bigType.bigName}</div></td>
	          <td><div align="center">${bigType.creaTime}</div></td>
	          <td><div align="center"><a href="javascript:deleteType('${bigType.id}')">删除</a></div></td>
	    	</tr>
    	</c:forEach>
      </table>
	  <br>
	  <table width="90%"  border="0" align="center" cellpadding="0" cellspacing="0">
        <tr align="center">
          <td style="font-size: 12px;" width="13%">共为${bigTypes.totalPage }页</td>
          <td  style="font-size: 12px;" width="16%">共有${bigTypes.totalCount }条记录</td>
          <td style="font-size: 12px;" width="14%">当前为第${bigTypes.currentPage }页</td>
          <td style="font-size: 12px;" width="19%">
       
        <c:if test="${1!=bigTypes.currentPage}">
				<li class="current"><a href='${pageContext.request.contextPath}/type_findAllBigType?currentPage=${bigTypes.currentPage-1}'>上一页</a></li>
			</c:if>
        </td>
      
          <td width="18%">
            
              <c:if test="${bigTypes.totalPage!=bigTypes.currentPage}">
				<li class="current"><a href='${pageContext.request.contextPath}/type_findAllBigType?currentPage=${bigTypes.currentPage+1}'>下一页</a></li>
			</c:if>
       	</td>

          <td width="20%">
            <div align="right"><img src="image/bg-add.gif" width="9" height="9"><a href="bg-bigTypeInsert.jsp">&nbsp;添加大类别&nbsp;</a></div></td>

        </tr>
      </table>

<P align="center"></P>
	
    </td>
  </tr>
</table>
<jsp:include page="bg-down.jsp" flush="true" />

</body>
</html>
