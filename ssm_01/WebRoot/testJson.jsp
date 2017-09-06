<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'testJson.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
  </head>
  
  <body>
    <script type="text/javascript">
    	function  request_json(){
    		$.ajax({
    			type:"post",
    			url:"${pageContext.request.contextPath }/editItemSubmit_RequestJson.action",
    			contentType:"application/json;charset=UTF-8",
    			data:'{"name":"测试商品","price":99.9}',
    			success:function(data){
					alert(data.name);
				}
    		})
    	}
    	
    	function formsubmit(){
			var user = " name=测试商品&price=99.9";
			//alert(user);
			  $.ajax(
				{
					type:'post',//这里改为get也可以正常执行
					url:'${pageContext.request.contextPath}/editItemSubmit_RequestJson.action',
					//ContentType没指定将默认为：application/x-www-form-urlencoded
					data:user,
					success:function(data){
						alert(data.name);
					}
					
				}	
			)
 }
    </script>
    <input type="button" value="发生json数据格式" onclick="request_json()"/>
     <input type="button" value="发生key-value数据格式" onclick="formsubmit()"/>
  </body>
</html>
