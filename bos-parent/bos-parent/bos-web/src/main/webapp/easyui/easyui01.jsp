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
	
	<link rel="stylesheet" href="${pageContext.request.contextPath }/js/ztree/zTreeStyle.css" type="text/css">
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/ztree/jquery.ztree.all-3.5.js"></script>
	
  </head>
  
  <body class="easyui-layout">
    <div style="height: 100px" data-options="region:'north'">北</div>
    <div style="width: 200px" data-options="region:'west'">
    	<div class="easyui-accordion" data-options="fit:true">
    		<div data-options="iconCls:'icon-cut'" title="面板一">
    			<a id="but1" class="easyui-linkbutton">添加一个选项卡</a>
				<script type="text/javascript">
					$(function(){
						//页面加载完成后，为上面的按钮绑定事件
						$("#but1").click(function(){
							//判断“系统管理”选项卡是否存在
							var e = $("#mytabs").tabs("exists","系统管理");
							if(e){
								//已经存在，选中就可以
								$("#mytabs").tabs("select","系统管理");
							}else{
								//调用tabs对象的add方法动态添加一个选项卡
								$("#mytabs").tabs("add",{
									title:'系统管理',
									iconCls:'icon-edit',
									closable:true,
									content:'<iframe frameborder="0" height="100%" width="100%" src="https://www.baidu.com"></iframe>'
								});
							}
						});
					});
				</script>

    		</div>
    		<div title="面板二">
    			<ul id="ztree2" class="ztree"></ul>
    			<script type="text/javascript">
    				$(function(){
    					var setting = {
    						data:{
    							simpleData:{
    								enable:true
    							}
   							},
   							callback:{
   								onClick:function(event, treeId, treeNode){
   									if(treeNode.page!==undefined){
   										//判断“系统管理”选项卡是否存在
										var e = $("#mytabs").tabs("exists",treeNode.name);
										if(e){
											//已经存在，选中就可以
											$("#mytabs").tabs("select",treeNode.name);
										}else{
											//调用tabs对象的add方法动态添加一个选项卡
											$("#mytabs").tabs("add",{
												title:treeNode.name,
												iconCls:'icon-edit',
												closable:true,
												content:'<iframe frameborder="0" height="100%" width="100%" src="https://www.baidu.com"></iframe>'
											});
										}
   									}
   								}
   							}
    					};
    					
    					var zNodes = [
    						{"id":"1","pId":"2",name:"节点一"},
    						{"id":"2","pId":"3",name:"节点二"},
    						{"id":"3","pId":"0",name:"节点三"}
    					];
    					
    					//使用ajax获取json数据
    					var url = "${pageContext.request.contextPath}/json/menu.json";
    					$.post(url,{},function(data){
    						$.fn.zTree.init($("#ztree2"), setting, data);
    					});
    					//调用API初始化ztree
						
    				});
    			</script>
    		</div>
    		<div title="面板三">
    			
    		</div>
    	</div>
    </div>
    <div data-options="region:'center'">
    	<div id="mytabs" class="easyui-tabs" data-options="fit:true">
    		<div data-options="iconCls:'icon-cut'" title="面板一">
    			<!-- 5	datagrid编辑功能使用方式 -->
    			<table id="mytablee"></table>
    			<script type="text/javascript">
    				$(function(){
    					var myIndex = -1;//全局变量，值为正在编辑行的索引
    					//加载datagrid
    					$("#mytablee").datagrid({
    						columns:[[
    							 {title:'编号',field:'id',checkbox:true},
    							   {width:150,title:'姓名',field:'name',editor:{
		    							   	type:'validatebox',
		    							   	options:{}
    							   }},
    							    {width:150,title:'年龄',field:'age',editor:{
													type:'numberbox',
					  								options:{}
								   }},
    							     {width:150,title:'日期',field:'address',editor:{
														type:'datebox',
						  								options:{}
								   }}
    						]],
    						//指定数据表格发送ajax请求的地址
							url:'${pageContext.request.contextPath }/json/datagrid_data.json',
    						rownumbers:true,
							singleSelect:true,
    						//定义工具栏
    						toolbar:[
						         {text:'添加',iconCls:'icon-add',
						        	 //为按钮绑定单击事件
						        	 handler:function(){
						        		 $("#mytablee").datagrid("insertRow",{
						        			 index:0,//在第一行插入数据
						        			 row:{}//空行
						        		 });
						        		 $("#mytablee").datagrid("beginEdit",0);
						        		 myIndex = 0;
						         	 }
						         },
						         {text:'删除',iconCls:'icon-remove',handler:function(){
						        	//获得选中的行对象
						        	 var rows = $("#mytablee").datagrid("getSelections");
						        	 if(rows.length == 1){
						        		 var row = rows[0];
						        		 //获得指定行对象的索引
						        		 myIndex = $("#mytablee").datagrid("getRowIndex",row);
						        	 }
						        	 $("#mytablee").datagrid("deleteRow",myIndex);
						        	 //$.post();
						         }},
						         {text:'修改',iconCls:'icon-edit',handler:function(){
						        	 //获得选中的行对象
						        	 var rows = $("#mytablee").datagrid("getSelections");
						        	 if(rows.length == 1){
						        		 var row = rows[0];
						        		 //获得指定行对象的索引
						        		 myIndex = $("#mytablee").datagrid("getRowIndex",row);
						        	 }
						        	 $("#mytablee").datagrid("beginEdit",myIndex);
						         }},
						         {text:'保存',iconCls:'icon-save',handler:function(){
						        	 $("#mytablee").datagrid("endEdit",myIndex);
						         }}
						         ],
						//显示分页条
						pagination:true,
						pageList:[3,5,7,10],
						//数据表格提供的用于监听结束编辑事件
						onAfterEdit:function(index,data,changes){
							console.info(data);
							$.post();
						}
					});
				});

    			</script>
    		</div>
    		<div data-options="closable:true,iconCls:'icon-remove'" title="面板二">
    			<table class="easyui-datagrid">
		<thead>
			<tr>
				<th data-options="field:'id'">编号</th>
				<th data-options="field:'name'">姓名</th>
				<th data-options="field:'age'">年龄</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>001</td>
				<td>小明</td>
				<td>90</td>
			</tr>
			<tr>
				<td>002</td>
				<td>老王</td>
				<td>3</td>
			</tr>
		</tbody>
	</table>
    			
    		</div>
    		<div title="面板三">
    			<!-- 表格  -->
    			<table id="mytable">
    				
    			</table>
    			<script type="text/javascript">
    				$(function(){
    					$("#mytable").datagrid({
    						columns:[[
    							{field:'id',title:'编号',checkbox:true},
    							 {title:'姓名',field:'name'},
						          {title:'年龄',field:'age'},
						          {title:'地址',field:'address'}
    						]],
    						url:'${pageContext.request.contextPath }/json/datagrid_data.json',
    						rownumbers:true,
							singleSelect:true,
    						//定义工具栏
    						toolbar:[
    							{
    								text:'添加',
    								iconCls:'icon-add',
    								handler:function(){
    									alert("ss");
    								}
    							},
    							{iconCls:'icon-remove',text:'删除'},
    							{text:'修改',iconCls:'icon-cut'},
    							{text:'查询',iconCls:'icon-search'}
    						],
    						//显示分页条
    						pagination:true
    					});
    				});
    				
    			</script>
    		</div>
    	</div>
    </div>
    <div style="width: 100px" data-options="region:'east'">东</div>
    <div style="height: 50px" data-options="region:'south'">南</div>
  </body>              
</html>
