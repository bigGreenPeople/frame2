<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page contentType="text/html; charset=gb2312"%>

<table width="788" height="66" border="0" align="center" cellpadding="0" cellspacing="0" background="image/bg_01.jpg">
  <tr>
    <td valign="top"><table width="770" border="0" align="center">
      <tr >
        <td width="413" height="53" valign="bottom"><div align="right"></div></td>
        <td width="347" valign="bottom" align="right"><font color="#FFFFFF"><a href="bg-orderSelect.jsp" class="a2">商品查询</a> | 
        <a href="${pageContext.request.contextPath }/type_findAllBigType" class="a2">大类别查询</a> | 
        <a href="${pageContext.request.contextPath }/type_findAllSmallType" class="a2">小类别查询</a> | 
        <a href="bg-orderSelect.jsp" class="a2">返回首页</a></font></td>
      </tr>
    </table></td>
  </tr>
</table>
<table width="788" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#000000">
  <tr>
    <td width="15" height="25">&nbsp;</td>
    <td width="579"><font color="#FFFFFF">当前登录：${loginManager.name }</font></td>
    <td width="194"><font color="#FFFFFF">今天是<% Date nowTime = new Date();
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    	String time = format.format(nowTime);
    %>
    <%=time %>
    </font></td>
  </tr>
</table>