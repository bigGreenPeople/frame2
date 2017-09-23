<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.sql.*,java.util.*"%>
 <script Language="JavaScript">
 function deleteType(date) {
  if(confirm("确定要删除吗？")){
    window.location="bigTypeAction.do?action=3&id="+date;
	}
  }
 </script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>手机销售系统</title>

</head>
 <link href="css/css.css" rel="stylesheet" type="text/css">
 <script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<body>

<jsp:include page="bg-up.jsp" flush="true"/>
<table width="788" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="170"  valign="top"><jsp:include page="bg-left.jsp" flush="true" /></td>
    <td width="618" align="center" valign="top" bgcolor="#FFFFFF"> <br>
	
        <table width="610" height="25" border="0" cellpadding="0" cellspacing="0" background="image/bg_02.jpg">
          <tr>
            <td><div align="center"><strong>商品查询</strong></div></td>
          </tr>
        </table>
        <br>

  <form action="${pageContext.request.contextPath }/goods_findGoods" method="post"  name="form" enctype="multipart/form-data" onSubmit="return checkEmpty(form)" >
        <table width="90%"  border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#CCCCCC">
          <tr>
            <td width="20%" height="26" style="font-size: 14px;">&nbsp;&nbsp;所属大类别</td>
            <td width="31%" bgcolor="#FFFFFF">&nbsp;&nbsp;
              <select name="goodsCondition.bigType_id" id="big"><option value="">请选择</option>
      			<c:forEach items="${list }" var="bigType">
              	 <option value="${bigType.id }">${bigType.bigName }</option> 
              </c:forEach>
            </select></td>
            <td width="20%" style="font-size: 14px;">&nbsp;&nbsp;所属于小类别</td>
            <td width="31%" bgcolor="#FFFFFF">&nbsp;
              <select name="goodsCondition.smallType_id" id="small"><option value="">-- 请选择 --</option>
            </select></td>
          </tr>
          <tr>
          	 <td width="20%" style="font-size: 14px;">&nbsp;&nbsp;商品名称</td>
          	 <td width="31%" bgcolor="#FFFFFF"  style="font-size: 12px;">&nbsp;
             	<input type="text" name="goodsCondition.goodsName" value=""/>
             </td>
             <td width="20%" style="font-size: 14px;">&nbsp;&nbsp;是否特价</td>
          	 <td width="31%" bgcolor="#FFFFFF"  style="font-size: 12px;">&nbsp;
             	<input type="radio" name="goodsCondition.mark" value="0"/>否
             	<input type="radio" name="goodsCondition.mark" value="1"/>是
             </td>
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
