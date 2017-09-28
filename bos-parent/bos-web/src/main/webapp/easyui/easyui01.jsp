<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'easyui01.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>

  </head>
  
  <body class="easyui-layout">
    <div style="height: 100px" data-options="region:'north'">北</div>
    <div style="width: 200px" data-options="region:'west'">
    	<div class="easyui-accordion" data-options="fit:true">
    		<div data-options="iconCls:'icon-cut'" title="面板一">1</div>
    		<div title="面板二">2</div>
    		<div title="面板三">3</div>
    	</div>
    </div>
    <div data-options="region:'center'">
    	<div class="easyui-tabs" data-options="fit:true">
    		<div data-options="iconCls:'icon-cut'" title="面板一">1</div>
    		<div data-options="closable:true" title="面板二">2</div>
    		<div title="面板三">3</div>
    	</div>
    </div>
    <div style="width: 100px" data-options="region:'east'">东</div>
    <div style="height: 50px" data-options="region:'south'">南</div>
  </body>              
</html>
