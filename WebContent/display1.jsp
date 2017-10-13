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
p{color:black;}
table,td,th
{
	border:1px solid black;
}
table
{
	width:35%;
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
<form method="post" onsubmit="return check(this);">
<fieldset>
<legend align="top"><s:property value="key"/>的作品集：</legend>
<table align="center" border="1">
<th>作品的名称</th>
<c:forEach var="item" items="${list}" varStatus="status">
      <tr><td><a href="findbook.action?title=${item}">${item}</a></td></tr>
</c:forEach>
</table>   
</fieldset>
</form>
<p style="color:black;font-size:22px;"><s:a href="#" onclick="history.back()">点击此处返回上一级</s:a></p>
<p style="color:black;font-size:22px;"><s:a href="directory.jsp">点击此处返回功能选择界面！</s:a></p>
<p style="color:black;font-size:22px;"><s:a href="index.jsp">点击此处返回登录界面！</s:a></p>
</body>
</html>