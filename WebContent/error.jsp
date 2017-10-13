<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<%@ taglib prefix="s" uri="/struts-tags" %>

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
<h1 align="center">哈工大心火图书管理系统</h1>
<audio autoplay>
  <source src="Noldream.mp3" type="audio/mpeg">
您的浏览器不支持 audio 元素。
</audio>
<center>
<p><s:property value="key"/>
<s:a href="#" onclick="history.back()">点击此处返回上一级</s:a></p>
<p style="color:black;"><s:a href="directory.jsp">操作失败，点击返回功能选择界面！</s:a></p>
<p style="color:black;"><s:a href="index.jsp">操作失败，点击返回登录界面！</s:a></p>
</center>
</body>
</html>