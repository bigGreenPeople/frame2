<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.sql.*,java.util.*"%>
 <script Language="JavaScript">
 function deleteAffiche(date) {
  if(confirm("确定要删除吗？")){
    window.location="${pageContext.request.contextPath}/affiche_deleteAffiche?id="+date;
	}
  }
 </script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>手机销售系统</title>
<style type="text/css">
<!--
.style1 {color: #5F5F5F}
-->
</style>
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
            <td><div align="center"><strong>公告信息的查询</strong></div></td>
          </tr>
        </table>
        <br>
		
	  <table width="90%"  border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#CCCCCC">
        <tr style="font-size: 14px;">
          <td width="17%" height="25"><div align="center">数据编号</div></td>
          <td width="19%"><div align="center">公告标题</div></td>
          <td width="27%"><div align="center">公告发布时间</div></td>
          <td width="37%"><div align="center">操作</div></td>
        </tr>
		  <c:forEach items="${affiches.list }" var="affiche">
        <tr bgcolor="#FFFFFF" style="font-size: 12px;">
          <td height="30"><div align="center" >${affiche.id}</div></td>
          <td><div align="center">${affiche.name}</div></td>
          <td><div align="center">${affiche.issue_Time}</div></td>
          <td><div align="center" ><a href="${pageContext.request.contextPath}/affiche_toUpdateAffiche?id=${affiche.id}">修改</a>&nbsp;&nbsp;
          <a href="${pageContext.request.contextPath}/affiche_showAfficheInfo?id=${affiche.id}">查询内容</a>&nbsp;&nbsp;
          <a href="javascript:deleteAffiche('${affiche.id}')">删除</a></div></td>
     </tr>
     </c:forEach>
      </table>
	  <br>
	  <table width="90%"  border="0" align="center" cellpadding="0" cellspacing="0">
        <tr align="center">
          <td style="font-size: 12px;" width="13%">共为${affiches.totalPage }页</td>
          <td  style="font-size: 12px;" width="16%">共有${affiches.totalCount }条记录</td>
          <td style="font-size: 12px;" width="14%">当前为第${affiches.currentPage }页</td>
          <td style="font-size: 12px;" width="19%">
       
        <c:if test="${1!=affiches.currentPage}">
				<li class="current"><a href='${pageContext.request.contextPath}/affiche_findAllAffiche?currentPage=${affiches.currentPage-1}'>上一页</a></li>
			</c:if>
        </td>
      
          <td width="18%">
            
              <c:if test="${affiches.totalPage!=affiches.currentPage}">
				<li class="current"><a href='${pageContext.request.contextPath}/affiche_findAllAffiche?currentPage=${affiches.currentPage+1}'>下一页</a></li>
			</c:if>
       	</td>

          <td width="20%">
            <div align="right"><img src="image/bg-add.gif" width="9" height="9"><a href="${pageContext.request.contextPath}/bg-afficheInsert.jsp">&nbsp;添加公告&nbsp;</a></div></td>
		</tr>
      </table>

<P align="center"></P>
	
    </td>
  </tr>
</table>

<jsp:include page="bg-down.jsp" flush="true" />

</body>
</html>
