<%@ page contentType="text/html; charset=gb2312"%>
<%@page import="java.sql.*,java.util.*"%>
 <script Language="JavaScript">
 function deleteAffiche(date) {
  if(confirm("确定要删除吗？")){
    window.location="afficheAction.do?action=3&id="+date;
	}
  }
 </script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
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
        <tr>
          <td width="17%" height="25"><div align="center">数据编号</div></td>
          <td width="19%"><div align="center">公告标题</div></td>
          <td width="27%"><div align="center">公告发布时间</div></td>
          <td width="37%"><div align="center">操作</div></td>
        </tr>
		   
        <tr bgcolor="#FFFFFF">
          <td height="30"><div align="center" >11</div></td>
          <td><div align="center">2017年国庆放假</div></td>
          <td><div align="center">2017-8-11 12:44:23</div></td>
          <td><div align="center" ><a href="bg-afficheUpdate.jsp">修改</a>&nbsp;&nbsp;<a href="bg-afficheContent.jsp">查询内容</a>&nbsp;&nbsp;<a href="javascript:deleteAffiche('')">删除</a></div></td>
     </tr>
      </table>
	  <br>
	  <table width="90%"  border="0" align="center" cellpadding="0" cellspacing="0">
        <tr align="center">
          <td width="13%">共为4页</td>
          <td width="16%">共有22条记录</td>
          <td width="14%">当前为第2页</td>
          <td width="19%">
      上一页
       
        <a href="afficheAction.do?action=0&i=">上一页</a></td>

          <td width="18%">
              <a href="afficheAction.do?action=0&i=">下一页</a></td>
    

          <td width="20%">&nbsp;
          <a href="bg-afficheInsert.jsp"><img src="image/bg-add.gif" width="9" height="9">&nbsp;添加公告</a></td>

        </tr>
      </table>

    </td>
  </tr>
</table>

<jsp:include page="bg-down.jsp" flush="true" />

</body>
</html>
