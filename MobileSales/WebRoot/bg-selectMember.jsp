<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.sql.*,java.util.*"%>
 <script Language="JavaScript">
 function deleteMember(date) {
  if(confirm("确定要删除吗？")){
    window.location="${pageContext.request.contextPath}/member_deleteMember?id="+date;
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
            <td><div align="center"><strong>会员信息的查询</strong></div></td>
          </tr>
        </table>
        <br>
				 
	    <table width="71%"  border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#CCCCCC">

	    <tr>
          <td width="14%" height="25" style="font-size: 14px;"><div align="center">编号</div></td>
          <td width="14%" style="font-size: 14px;"><div align="center">会员账号</div></td>
          <td width="14%" style="font-size: 14px;"><div align="center">会员姓名</div></td>
           <td width="14%" style="font-size: 14px;"><div align="center">会员年龄</div></td>

    <td width="38%" style="font-size: 14px;"><div align="center">操作</div></td>
        </tr>
        <c:forEach items="${members.list }" var="member">
	        <tr bgcolor="#FFFFFF" style="font-size: 12px;">
	          <td height="30"><div align="center">${member.id }</div></td>
	          <td><div align="center">${member.name }</div></td>
	          <td><div align="center">${member.reallyName }</div></td>
	          <td><div align="center">${member.age }</div></td>
	        <td><div align="center">
	
			 <a href="${pageContext.request.contextPath}/member_showMember?id=${member.id }">详细信息</a>&nbsp;&nbsp;&nbsp;&nbsp;
	
			 <a href="javascript:deleteMember('${member.id }')">删除</a>
	
			  </div></td>
	        </tr>
	        </c:forEach>
      </table><br>
	   <table width="90%"  border="0" align="center" cellpadding="0" cellspacing="0">
        <tr align="center">
          <td style="font-size: 12px;" width="13%">共为${members.totalPage }页</td>
          <td  style="font-size: 12px;" width="16%">共有${members.totalCount }条记录</td>
          <td style="font-size: 12px;" width="14%">当前为第${members.currentPage }页</td>
          <td style="font-size: 12px;" width="19%">
       
        <c:if test="${1!=members.currentPage}">
				<li class="current"><a href='${pageContext.request.contextPath}/member_findAllMember?currentPage=${members.currentPage-1}'>上一页</a></li>
			</c:if>
        </td>
      
          <td width="18%">
              <c:if test="${members.totalPage!=members.currentPage}">
				<li class="current"><a href='${pageContext.request.contextPath}/member_findAllMember?currentPage=${members.currentPage+1}'>下一页</a></li>
			</c:if>
       	</td>

          <%-- <td width="20%">
            <div align="right"><img src="image/bg-add.gif" width="9" height="9"><a href="${pageContext.request.contextPath}/goods_toAddGoods">&nbsp;添加商品&nbsp;</a></div></td> --%>
		</tr>
      </table>

<P align="center"></P>
	
    </td>
  </tr>
</table>
<jsp:include page="bg-down.jsp" flush="true" />
</body>
</html>
