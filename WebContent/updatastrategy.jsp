<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ page import="java.sql.*" %>

<html>
<head>
<meta charset=UTF-8">
<title>欢迎使用哈工大版图书管理查询系统</title>
<style>
a:link {color: black}              
a:visited {color: black}
table,td,th
{
	border:1px solid black;
}
table
{
	width:50%;
}
th
{
	height:50px;
}
td
{
    text-align:center;
    color:black;
}
</style>
</head>
<body background="snow.jpg"style=" background-repeat:no-repeat ;background-size:100% 100%; background-attachment:fixed;">
<form action="update.action" method="post" onsubmit="return check(this);">
<fieldset>
<legend align="top">图书的更新信息：</legend>
<table align="center" border="1">
<tr>
  <td>书       名   : </td>
  <td><input type="text" name="title" maxlength="20" required></td>
  </tr>
  <tr>
  <td>作       者   : </td>
  <td><input type="text" name="name" maxlength="10" required></td>
  </tr>
  <tr>
  <td>出  版  社  : </td>
  <td><input type="text" name="publisher" maxlength="20"></td>
  </tr>
  <tr>
  <td>出版日期: </td>
  <td><input type="text" name="publishdata" maxlength="8"></td>
  </tr>
  <tr>
  <td>价      格  : </td>
  <td><input type="number" name="price" maxlength="4" min="0"></td>
  </tr>
</table><br>
<center><input type="submit" value="提交">
<input type="reset"></center>
<right><p>如有填写有误，请点击“重置”键</p></right>
<p>除了必填项以外，在需要更新的数据后面填写新的数据，不需更新的空着即可</p>
</fieldset>
</form>
<p id="black"><s:a href="#" onclick="history.back()">点击此处返回上一级</s:a></p>
<p><s:a href="directory.jsp">点击此处返回功能选择界面！</s:a></p>
<p><s:a href="index.jsp">点击此处返回登录界面！</s:a></p>
</body>
</html>