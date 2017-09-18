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
	<strong>订单查看</strong>
	 <br>	 <br>	 <br>
            
     没有订货信息
 

		  <table width="95%"  border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolorlight="#FFFFFF" bordercolordark="#819BBC">

       <tr align="center">
            <td width="15%" height="21">编号</td>

            <td width="15%">电话</td>
            <td width="21%">地址</td>

            <td width="19%">订货时间</td>
            <td width="18%">是否出货</td> <td width="12%">操作</td>
          </tr>
    
          <tr align="center">
            <td height="24">23233</td>

            <td>13565667784</td>
            <td>江西地址</td>

            <td>2017-08-12</td>
            <td>
            否 是
            </td>
             <td><a href="cart_detail.jsp?number=">查看明细</a></td>
          </tr>

      </table>
      <div align="center">
		   <br>
	      <br>
	      订货明细查询
	      <br>
<br>

      <table width="89%"  border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolorlight="#FFFFFF" bordercolordark="#819BBC">

        <tr align="center">
          <td width="25%" height="21">编号</td>
          <td width="24%">商品名称</td>
          <td width="28%">商品价格</td>
          <td width="23%">商品数量</td>
        </tr>  
        <tr  align="center" >
          <td height="21">1111</td>
          <td>华为荣耀5C></td>
          <td>2334元</td>
          <td>23</td>
        </tr>
      </table>

	   <table width="89%"  border="0" cellspacing="0" cellpadding="0">
         <tr>
           <td height="24"><div align="right">总金额：2333元</div></td>
         </tr>
       </table>
      </div>
</td>
  </tr>
</table>

<jsp:include page="fg-down.jsp" flush="true"/>

</body>
</html>
