<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.sql.*,java.util.*"%>
 <script Language="JavaScript">
 function deleteManager(date) {
  if(confirm("确定要删除吗？")){
    window.location="manager_deleteManager?id="+date;
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
            <td><div align="center"><strong>管理员信息的查询</strong></div></td>
          </tr>
        </table>
        <br>
	 <table width="90%"  border="0" cellspacing="0" cellpadding="0">
            <tr>
          <td width="20%" height="20" colspan="4"><div align="right"><a href="bg-managerUpdatePassword.jsp">修改您的密码</a>&nbsp;&nbsp;&nbsp;</div></td>
        <tr>
      </table>
	    <table width="90%"  border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#CCCCCC">    
	    <tr style="font-size: 14px;">
          <td width="20%" height="25"><div align="center">数据编号</div></td>
          <td width="20%"><div align="center">管理员用户名</div></td>
          <td width="20%"><div align="center">管理员姓名</div></td>
          <td width="44%"><div align="center">操作</div></td>
        </tr>
		<c:forEach items="${managers.list}" var="manager">
        <tr bgcolor="#FFFFFF" style="font-size:12px;">
	          <td height="30"><div align="center">${manager.id}</div></td>
	          <td><div align="center">${manager.account}</div></td>
	          <td><div align="center">${manager.name}</div></td>
	          <td><div align="center">
	
	         <a href="javascript:deleteManager('${manager.id}')">删除</a> 
	          </div></td>
	        </tr>
        </c:forEach>
	
      </table><br>
	   <table width="90%"  border="0" align="center" cellpadding="0" cellspacing="0">
        <tr align="center">
          <td style="font-size: 12px;" width="13%">共为${managers.totalPage }页</td>
          <td  style="font-size: 12px;" width="16%">共有${managers.totalCount }条记录</td>
          <td style="font-size: 12px;" width="14%">当前为第${managers.currentPage }页</td>
          <td style="font-size: 12px;" width="19%">
       
        <c:if test="${1!=managers.currentPage}">
				<li class="current"><a href='${pageContext.request.contextPath}/manager_findAllManager?currentPage=${smallTypes.currentPage-1}'>上一页</a></li>
			</c:if>
        </td>
      
          <td width="18%">
            
              <c:if test="${managers.totalPage!=managers.currentPage}">
				<li class="current"><a href='${pageContext.request.contextPath}/manager_findAllManager?currentPage=${smallTypes.currentPage+1}'>下一页</a></li>
			</c:if>
       	</td>

          <td width="20%">
            <div align="right"><img src="image/bg-add.gif" width="9" height="9"><a href="${pageContext.request.contextPath}/bg-managerInsert.jsp">&nbsp;添加管理员&nbsp;</a></div></td>
		</tr>
      </table>

<P align="center"></P>
	
    </td>
  </tr>
 
 <%
if(request.getAttribute("reslut")!=null){
%>
<P align="center"><%=request.getAttribute("reslut")%></P>
<%}%>	

 		
</table>		
<jsp:include page="bg-down.jsp" flush="true" />
</body>
</html>
