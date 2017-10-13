<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>欢迎使用哈工大版图书管理查询系统</title>
<style type="text/css">
  body{margin:0;padding:0}
  </style>
<style>
a:link {color: black}              
a:visited {color: black}
</style>
</head>
<body background="snow.jpg"style=" background-repeat:no-repeat ;background-size:100% 100%; background-attachment:fixed;">
<h1 align="center">哈工大心火图书管理系统</h1>
<form action="addinformations.action" method="post" onsubmit="return check(this);">
<fieldset>
  <legend align="top">用       户         登         录:</legend>
  <table align="center" border="1">
  <tr>
  <td>姓       名   : </td>
  <td><input type="text" name="name" maxlength="10" required></td>
  </tr>
  <tr>
  <td>性       别   : </td>
  <td><input type="text" name="sex" maxlength="1" required></td>
  </tr>
  <tr>
  <td>手  机  号  : </td>
  <td><input type="tel" name="telephone" maxlength="11" required></td>
  </tr>
  <tr>
  <td>Email: </td>
  <td><input type="email" name="email" maxlength="20" required></td>
  </tr>
  <tr>
  <td>所在学校  : </td>
  <td><input type="text" name="school" maxlength="20" required></td>
  </tr>
  <tr>
  <td>学       号   : </td>
  <td><input type="text" name="studynumber" maxlength="15" required></td>
  </tr>
  <tr>
  <td>生       日   : </td>
  <td><input type="text" name="birthday" maxlength="8" placeholder="例：19970422" required><br></td>
  </tr>
  </table><br>
 <!--  <ul>
<li>姓       名   : <input type="text" name="姓       名   " required><br></li>
<li>性       别   : <input type="text" name="性       别   " required><br></li>
<li>手  机  号  : <input type="text" name="手  机  号  " required><br></li>
<li>E-mail: <input type="text" name="E-mail" required><br></li>
<li>所在学校  : <input type="text" name="所在学校  " required><br></li>
<li>学       号   : <input type="text" name="学       号   " required><br></li>
<li>生       日   : <input type="text" name="生       日   " required><br></li></ul>-->
<center><input type="submit" value="登录">
<input type="reset"></center>
<right><p>如有填写有误，请点击“重置”键</p></right>
</fieldset>
</form>
</body>
</html>
