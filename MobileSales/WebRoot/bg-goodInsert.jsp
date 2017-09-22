<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.sql.*,java.util.*"%>
<script language="javascript">
function checkEmpty(form){
for(i=0;i<form.length;i++){
if(form.elements[i].value==""){
alert("表单信息不能为空");
return false;
}
}
if(isNaN(document.form.nowPirce.value)){
window.alert("价格只能为数字");
return false;
}
}
function ChangeItem(){
var big=form.big.value;
window.location.href="goodsAction.do?action=2&bigId="+big;
}
</script>
<script type="text/javascript" src="js/jquery-1.8.2.min.js">
</script>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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
            <td><div align="center"><strong>添加商品信息</strong></div></td>
          </tr>
        </table>
        <br>

  <form action="${pageContext.request.contextPath }/goods_addGoods" method="post" enctype="multipart/form-data"  name="form" enctype="multipart/form-data" onSubmit="return checkEmpty(form)" >
        <table width="90%"  border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#CCCCCC">
          <tr>
            <td width="20%" height="26" style="font-size: 14px;">&nbsp;&nbsp;所属大类别</td>
            <td width="31%" bgcolor="#FFFFFF">&nbsp;&nbsp;
              <select name="goods.smallType.bigType.id" id="big"><option value="">请选择</option>
      			<c:forEach items="${list }" var="bigType">
              	 <option value="${bigType.id }">${bigType.bigName }</option> 
              </c:forEach>
            </select></td>
            <td width="20%" style="font-size: 14px;">&nbsp;&nbsp;所属于小类别</td>
            <td width="31%" bgcolor="#FFFFFF">&nbsp;
              <select name="goods.smallType.id" id="small"><option value="">-- 请选择 --</option>

            </select></td>
          </tr>
          <tr>
            <td height="25" style="font-size: 14px;">&nbsp;&nbsp;商品名称</td>
            <td bgcolor="#FFFFFF">&nbsp;&nbsp;
            <input name="goods.goodsName" type="text" size="20"></td>
            <td style="font-size: 14px;">&nbsp;&nbsp;生产厂商</td>
            <td bgcolor="#FFFFFF">&nbsp;
            <input name="goods.goodsFrom" type="text" size="20"></td>
          </tr>
          <tr>
            <td height="27" style="font-size: 14px;">&nbsp;&nbsp;商品定价</td>
            <td bgcolor="#FFFFFF">&nbsp;&nbsp;
            <input name="goods.nowPrice" type="text" size="20"></td>
            <td style="font-size: 14px;">&nbsp;&nbsp;初始化特价</td>
            <td bgcolor="#FFFFFF">&nbsp;
            <input name="goods.freePrice" type="hidden" size="20" value="0">0元</td>
          </tr>
		  
		  <tr>
            <td height="28" style="font-size: 14px;">&nbsp;&nbsp;商品图片</td>
            <td colspan="3" bgcolor="#FFFFFF">&nbsp;&nbsp;
            <input name="fieldName" type="file" id="formFile"></td>
          </tr>
		  
		  
          <tr>
            <td height="28" style="font-size: 14px;">&nbsp;&nbsp;简介</td>
            <td colspan="3" bgcolor="#FFFFFF">&nbsp;&nbsp;
            <input name="goods.introduce" type="text" size="50"></td>
          </tr>
        </table><br>
     <input type="image" class="input1"  src="image/save.jpg" width="51" height="20">
&nbsp;&nbsp;
      <a href="#" onClick="javascript:form.reset()"><img src="image/clear.gif"></a>
&nbsp;&nbsp;
      <a href="#" onClick="javasrcipt:history.go(-1)"><img src="image/back.gif"></a>
	  </form>
	
	
	
	
    </td>
  </tr>
</table>
<jsp:include page="bg-down.jsp" flush="true" />






<script type="text/javascript">
	$("#big").change(function(){
			//删除原小类别下拉框中的内容，除第一项外
			$("#small option:gt(0)").remove();
			var bigTypeId = $("#big option:selected").val();
			/* if("" != bigTypeId){
				//alert("ajax开始"+bigTypeId);
				$.ajax({
					"type":"POST",
					 contentType:"application/json; charset=utf-8",
					"url":"${pageContext.request.contextPath}/goods_findSmallTypeByBigTypeAjax?time="+new Date().getTime(),
					data:{"bigTypeId":bigTypeId},
					"dataType":"json",
					"success":function(backData,textStatus,ajax){
						var types = backData.smallTypes;
						//alert(city);
						//jquery对象
						var $types = $(types);
						
						types.each(function(){
							//this表示每个小类别
							alert(this.smallName);
							var $option = $("<option>" + this.smallName + "</option>");
							$("#small").append( $option );
						});
					}
				});  
				}*/
				$.ajax({
		  			data:{"bigTypeId":bigTypeId},
		  			dataType:"json",
		  			url:"${pageContext.request.contextPath}/goods_findSmallTypeByBigTypeAjax?time="+new Date().getTime(),
		  			type:"post",
		  			success:function(html){
					    var types = html.smallTypes;
					    var $types = $(types);
						
						$types.each(function(){
							//this表示每个小类别
							//alert(this.smallName);
							var $option = $("<option value='"+this.id+"'>" + this.smallName + "</option>");
							$("#small").append( $option );
						});
					 }
		  		})
			
		});
	
</script>
















</body>
</html>
