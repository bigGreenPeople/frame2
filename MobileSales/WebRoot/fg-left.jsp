<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>手机销售系统</title>
</head>
<script language="javascript">
function checkEmpty(form){
for(i=0;i<form.length;i++){
if(form.elements[i].value==""){
alert("表单信息不能为空");
return false;
}
}
}
function quit() {
  if(confirm("没有要买的东西了吗？")){
    window.location.href="${pageContext.request.contextPath }/member_memberOut";
	}
  }
</script>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<body>
<!--左侧01-->
	
	<c:if test="${session.loginMember==null }">
	<table width="100%" height="138"  border="0" cellpadding="0" cellspacing="0" background="image/fg_left01.jpg">
      <tr>
        <td valign="top"><table width="100%"  border="0" cellpadding="0" cellspacing="0">
		 <tr>
            <td height="16">&nbsp;</td>
          </tr>
        </table>
        <form name="form" method="post" action="${pageContext.request.contextPath }/member_login" onSubmit="return checkEmpty(form)">
          <table width="185" border="0" align="center" style="font-size: 12px;">
          	<tr><br></tr>
            <tr>
              <td width="60" height="25">用户名：</td>
              <td width="115"> <input name="name" type="text" size="17"></td>
            </tr>
            <tr>
              <td height="25">密&nbsp;&nbsp;码：</td>
              <td><input name="password" type="password" size="17"></td>
            </tr>
			 <tr>
              <td height="26"><input type="image" class="input1"  src="image/fg-land.gif" width="51" height="20"></td>
              <td height="26">  &nbsp;&nbsp;<a href="fg-memberRegister.jsp">注册</a>&nbsp;&nbsp;<a href="fg-One.jsp">找回密码？</a></td>
			 </tr>	  
          </table>
		  </form>
		  </td>
      </tr>
    </table>
</c:if>
	<c:if test="${session.loginMember!=null }">
	<table width="100%" height="138"  border="0" cellpadding="0" cellspacing="0" background="image/fg_left01.jpg">
      <tr>
        <td valign="top"><table width="100%"  border="0" cellpadding="0" cellspacing="0">
		 <tr>
            <td height="30">&nbsp;</td>
          </tr>
        </table>
       
          <table width="167" border="0" align="center">
            <tr>
              <td width="161" height="25"><font color="#FB6801"><b>${loginMember.name }</b>,</font>欢迎回来</td>
              </tr>
            <tr>
              <td height="25">${loginTime }</td>
              </tr>
			 <tr>
              <td height="25" >会员姓名：${session.loginMember.reallyName }</td>
              </tr>	 
			  <tr>
              <td height="20" align="right" valign="middle"><a href="javascript:quit()">安全退出</a></td>
              </tr>	
          </table>
	  </td>
     </tr>
    </table>
</c:if>
	<!--左侧02-->		
        <table width="100%" height="194" border="0" background="image/fg_left02.jpg">
          <tr>
            <td valign="top"><table width="150" border="0">
              <tr>
                <td height="32">&nbsp;</td>
              </tr>
            </table>
              <table width="179" border="0" align="center">
                <tr>
                  <td width="171" height="143" ><font color="red">
				  <marquee direction="up" height="114" onmouseout="this.start()" 
             onmouseover="this.stop()" scrollAmount="1" scrollDelay="1">	  
		            <c:forEach items="${affiches }" var="affiche">
						<img src="image/sign.gif">&nbsp;<a href="#" onClick="window.open('fg-afficheSelect.jsp?id=','','width=700,height=360');">${affiche.name }
</a><br><br></c:forEach>
					
            </marquee></font>			      </td>
                </tr>
              </table></td>
          </tr>
        </table>	
	    <table width="100%" height="193" border="0" cellpadding="0" cellspacing="0" background="image/fg_left03.jpg">
          <tr>
            <td valign="top"><table width="194" border="0">
              <tr>
                <td height="40">&nbsp;</td>
              </tr>
            </table>          
		
			  <table width="178" style="line-height: 19px;" height="19" border="0" align="center" cellpadding="0" cellspacing="0" background="image/fg_left04.jpg">
			   
			    <c:forEach items="${goodss.list }" varStatus="status" var="goods"> <tr>
			    <td width="14"></td><td width="164">
                <a href="bg-sellResult.jsp?id=%>&account=">${status.index+1}&nbsp;&nbsp;${goods.goodsName }</a></td>
				</tr> 
                </c:forEach>  
            </table>				
			</td>
          </tr>
        </table>
	    <table width="207" height="181" border="0" cellpadding="0" cellspacing="0" background="image/fg_left05.jpg">
          <tr>
            <td valign="top"><table width="173">
              <tr>
                <td height="35">&nbsp;</td>
              </tr>
            </table>
              <table width="186" align="center">
                <tr>
                  <td height="38">
				  <MARQUEE direction="up" height="114" onmouseout="this.start()" 
             onmouseover="this.stop()" scrollAmount="1" scrollDelay="1">	  
		          <c:forEach items="${links }" var="link">
		          	<img src="image/sign1.gif">&nbsp; <a href="http://${link.linkAddress}" target="_blank">${link.linkName  }</a><br><br>
		          </c:forEach>
				
            </marquee>				 </td>
                </tr>
              </table></td>
          </tr>
      </table>
</body>
</html>
