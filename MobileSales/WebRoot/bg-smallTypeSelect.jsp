<%@ page contentType="text/html; charset=gb2312"%>
<%@page import="java.sql.*,java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
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
          <td width="10%" height="25"><div align="center">数据编号</div></td>
          <td width="18%"><div align="center">小类别名称</div></td>
		  <td width="20%"><div align="center">属于大类别名称</div></td>
          <td width="27%"><div align="center">创建时间</div></td>

          <td width="25%"><div align="center">操作</div></td>
        </tr>
 
        <tr bgcolor="#FFFFFF">
          <td height="30"><div align="center">11</div></td>
          <td><div align="center">华为荣耀</div></td>
		  <td><div align="center">
		  
		  <a href="smallTypeAction.do?action=6&bigId=">华为</a>
		 
		  </div></td>
          <td><div align="center">2017.8.12</div></td>                                                                                                                                                                                                   
       
		 <td>  
		   <div align="center">   
		  <a href="smallTypeAction.do?action=3&id=">删除</a> </div>
		
		 <div align="center">  无操作 </div>
		  </td>
	 </tr>
      </table> 
	  <br>
	  <table width="90%"  border="0" align="center" cellpadding="0" cellspacing="0">
        <tr align="center">
          <td width="13%">共为5页</td>
          <td width="16%">共有23条记录</td>
          <td width="14%">当前为第2页</td>
          <td width="19%">
      上一页
        <a href="smallTypeAction.do?action=0&i=">上一页</a>
		 <a href="smallTypeAction.do?action=6&i=&bigId=">上一页</a>
		</td>
          <td width="18%">
            下一页
        <a href="smallTypeAction.do?action=0&i=">下一页</a>
             <a href="smallTypeAction.do?action=6&i=&bigId=">下一页</a>
</td>
<td width="20%"><a href="bg-smallTypeInsert.jsp">添加小类别&nbsp;</a></td>
        </tr>
      </table>
<P align="center">ddd</P>
    </td>
  </tr>
</table>
<jsp:include page="bg-down.jsp" flush="true" />
</body>
</html>
