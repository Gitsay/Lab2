<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%   String strRadio = request.getParameter("identity");%>
<!DOCTYPE html >
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="java.sql.*" %>

<html>
<head>
<meta charset=UTF-8">
<title>欢迎使用哈工大版图书管理查询系统</title>
<style>
a:link {color: black}              
a:visited {color: black}
</style>
</head>
<body background="snow.jpg"style=" background-repeat:no-repeat ;background-size:100% 100%; background-attachment:fixed;">
<h1 align="center">请选择您所需要的功能并输入</h1>
<form method="post" onsubmit="return check(this);">
<div align="center" >
<fieldset style="width:600px;">
<legend>请输入作者名，查询所有书目:</legend>
<input type="radio" name="identity" value="ex1">
作者的名字: <input type="text" name="name" maxlength="10">
<input type="submit" formaction="findauthor.action" value="提交">
</fieldset>
</div>

<div align="center" >
<fieldset style="width:600px;">
<legend>添加图书:</legend>
<input type="radio" name="identity" value="ex2">
<table align="center" border="1">
  <tr>
  <td>书       名 : </td>
  <td><input type="text" name="title" maxlength="20"></td>
  </tr>
  <tr>
  <td>作       者   : </td>
  <td><input type="text" name="name1" maxlength="10"></td>
  </tr>
  <tr>
  <td>ISBN  : </td>
  <td><input type="text" name="iSBN" maxlength="17"></td>
  </tr>
  <tr>
  <td>出  版  社 : </td>
  <td><input type="text" name="publisher" maxlength="20"></td>
  </tr>
  <tr>
  <td>出版日期: </td>
  <td><input type="text" name="publishdata" maxlength="8" placeholder="例：19970422"></td>
  </tr>
  <tr>
  <td>价     格  : </td>
  <td><input type="number" name="price" maxlength="4" min="0"></td>
  </tr>
  </table>
<input type="submit" formaction="increasebook.action" value="增加">
</fieldset>
</div>

</form>
<br>
<p id="black"><s:a href="#" onclick="history.back()">点击此处返回上一级</s:a></p>
<p><s:a href="index.jsp">点击返回登录界面！</s:a></p>
<br>
</body>
</html>