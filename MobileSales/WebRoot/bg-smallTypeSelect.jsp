<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.sql.*,java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
 <script type="text/javascript" Language="JavaScript">
 function deleteType(date) {
  if(confirm("确定要删除吗？")){
    window.location="${pageContext.request.contextPath}/type_deleteSmallType?smallType.id="+date;
	}
  }
 </script>
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
            <td><div align="center"><strong>商品小类别查询</strong></div></td>
          </tr>
        </table>
        <br>


	  <table width="90%"  border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#CCCCCC">
	  
        <tr>
          <td width="12%" height="25"><div style="font-size: 14px;" align="center">数据编号</div></td>
          <td width="18%"><div style="font-size: 14px;" align="center">小类别名称</div></td>
		  <td width="20%"><div style="font-size: 14px;" align="center">属于大类别名称</div></td>
          <td width="27%"><div style="font-size: 14px;" align="center">创建时间</div></td>
                                                  
          <td width="25%"><div style="font-size: 14px;" align="center">操作</div></td>
        </tr>                                     
 		<c:forEach items="${smallTypes.list }" var="smallType">
	        <tr bgcolor="#FFFFFF">
	          <td height="30"><div align="center">${smallType.id }</div></td>
	          <td><div align="center">${smallType.smallName }</div></td>
			  <td><div align="center">
			  
			  <a href="smallTypeAction.do?action=6&bigId=">${smallType.bigType.bigName }</a>
			 
			  </div></td>
	          <td><div align="center">${smallType.creaTime }</div></td>                                                                                                                                                                                                   
	       
			 <td>  
			   <div align="center">   
			  <a href="javascript:deleteType('${smallType.id}')">删除</a> </div>
			
			 <!-- <div align="center">  无操作 </div> -->
			  </td>
			 </tr>
	 </c:forEach>
     	 </table> 
	  <br>
	  <table width="90%"  border="0" align="center" cellpadding="0" cellspacing="0">
        <tr align="center">
          <td style="font-size: 12px;" width="13%">共为${smallTypes.totalPage }页</td>
          <td  style="font-size: 12px;" width="16%">共有${smallTypes.totalCount }条记录</td>
          <td style="font-size: 12px;" width="14%">当前为第${smallTypes.currentPage }页</td>
          <td style="font-size: 12px;" width="19%">
       
        <c:if test="${1!=smallTypes.currentPage}">
				<li class="current"><a href='${pageContext.request.contextPath}/type_findAllSmallType?currentPage=${smallTypes.currentPage-1}'>上一页</a></li>
			</c:if>
        </td>
      
          <td width="18%">
            
              <c:if test="${smallTypes.totalPage!=smallTypes.currentPage}">
				<li class="current"><a href='${pageContext.request.contextPath}/type_findAllSmallType?currentPage=${smallTypes.currentPage+1}'>下一页</a></li>
			</c:if>
       	</td>

          <td width="20%">
            <div align="right"><img src="image/bg-add.gif" width="9" height="9"><a href="${pageContext.request.contextPath}/type_toAddSmallType">&nbsp;添加小类别&nbsp;</a></div></td>
		</tr>
      </table>

<P align="center"></P>
	
    </td>
  </tr>
</table>
<jsp:include page="bg-down.jsp" flush="true" />
</body>
</html>
