<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>�޸�ѧ����Ϣ</title>
<style type="text/css">
<!--
body {
	margin-top: 0px;
	margin-bottom: 0px;
}
-->
</style>
</head>
<body background="background.GIF">
<center>
<jsp:include page="top.jsp"/>
<form action="" method="post">
  <table width="424" height="57" border="1">
    <caption align="center">
    <font color=red size=5>�޸�ѧ����Ϣ</font>
            </caption>
    <tr>
      <td>ѧ��:</td>
      <td><input type="text" name="id"/></td>
    </tr>
    <tr>
      <td>����:</td>
      <td><input type="text" name="name"/></td>
    </tr>
    <tr>
      <td>�Ա�:</td>
      <td><input type="radio" name="sex" checked value="��"/>
        ��
        <input type="radio" name="sex" value="Ů"/>
        Ů </td>
    </tr>
    <tr>
      <td>��������:</td>
      <td><input type="text" name="birthday"/><font color=red>Ĭ�ϸ�ʽΪ:*2014/1/2</font></td>
    </tr>
    <tr>
      <td>רҵ:</td>
      <td><select name="major" id="select">
          <option >--��ѡ��רҵ--</option>
          <option value="������ҵ����">������ҵ����</option>
          <option value="���ѧ">���ѧ</option>
          <option value="������������">������������</option>
          <option value="��������缼��">��������缼��</option>
          <option value="����Ӣ��">����Ӣ��</option>
          <option value="Ӧ�õ��Ӽ���">Ӧ�õ��Ӽ���</option>
          <option value="���ؼ���">���ؼ���</option>
          <option value="����һ�廯">����һ�廯</option>
          <option value="Ӧ����ѧ">Ӧ����ѧ</option>
          <option value="ͨ�Ź���">ͨ�Ź���</option>
          <option value="Ӧ�û�ѧ">Ӧ�û�ѧ</option>
          <option value="���﹤��">���﹤��</option>
      </select></td>
    </tr>
    <tr>
      <td>�ɼ�:</td>
      <td><input type="text" name="score"/></td>
    </tr>
    <tr>
      <td>�绰:</td>
      <td><input type="text" name="tel"/></td>
    </tr>
    <tr align="center">
      <td colspan="2"><input type="submit" value="��   ��"/>
        &nbsp;&nbsp;
        <input type="reset" value="ȡ   ��"/>
      </td>
    </tr>
  </table>
</form>
<jsp:include page="bottom.jsp"/>
</center>
</body>
</html>
