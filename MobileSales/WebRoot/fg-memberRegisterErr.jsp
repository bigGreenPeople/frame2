<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page import="java.sql.*,java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>手机销售系统</title>
</head>
<link href="css/css.css" rel="stylesheet" type="text/css"> 

<body>
<jsp:include page="fg-top.jsp" flush="true"/>
<table width="766" border="0" align="center" cellpadding="0" cellspacing="0" bordercolor="#000000">
  <tr>
    <td bgcolor="#F5F5F5" align="center">
		<img src="image/fg1.jpg" width="752" height="39">
		<table width="270"  border="0" cellspacing="0" cellpadding="0">
				<tr><td><s:fielderror fieldName="loginerr"/></td></tr>
				<tr><td><s:fielderror fieldName="name"/></td></tr>
				<tr><td><s:fielderror fieldName="password"/></td></tr>
				<tr><td><s:fielderror fieldName="reallyName"/></td></tr>
		 </table>
      </td>
  </tr>
</table>
<jsp:include page="fg-down.jsp" flush="true"/>
</body>
</html>
