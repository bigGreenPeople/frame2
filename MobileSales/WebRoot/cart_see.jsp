<%@ page contentType="text/html; charset=gb2312" %>
<%@ page import="java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>手机销售系统</title>

</head>
 <link href="css/css.css" rel="stylesheet" type="text/css">
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
           您还没有购物！！！
        </div>
        <form method="post" action="cart_modify.jsp" name="form">
		  <table width="92%"  border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#819BBC" bordercolorlight="#FFFFFF">
          <tr>
            <td width="16%" height="28"><div align="center">序号</div></td>
            <td width="23%"><div align="center">商品的名称</div></td>
            <td width="22%"><div align="center">商品价格</div></td>
            <td width="22%"><div align="center">商品数量</div></td>
            <td width="17%"><div align="center">总金额</div></td>
          </tr>
         
          <tr>
            <td height="28"><div align="center">2</div></td>
            <td><div align="center">华为荣耀5C</div></td>
            <td><div align="center">2300元</div></td>
            <td><div align="center"><input name="num" size="7" type="text"  value="34" onBlur="check(this.form)"></div></td>
            <td><div align="center">12223元</div></td>
          </tr>

        </table>
        </form>

<table width="100%" height="52" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr align="center" valign="middle">
		<td height="10">&nbsp;		</td>
        <td width="24%" height="10" colspan="-3" align="left">&nbsp;</td>
		</tr>
      <tr align="center" valign="middle">
        <td height="21" class="tableBorder_B1">&nbsp;</td>
        <td height="21" colspan="-3" align="left" >合计总金额：￥5456</td>
      </tr>
      <tr align="center" valign="middle">
        <td height="21" colspan="2"> <a href="index.jsp">继续购物</a> | <a href="cart_checkOut.jsp">去收银台结账</a> | <a href="cart_clear.jsp">清空购物车</a> | <a href="#">修改数量</a></td>
        </tr>
</table>
</td>
  </tr>
</table>
<jsp:include page="fg-down.jsp" flush="true"/>

</body>
</html>
