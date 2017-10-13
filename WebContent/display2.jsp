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
	width:90%;
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
<legend align="top">图书的详细信息：</legend>
<table align="center" border="1">
<tr>
<td>ISBN</td>
<td>Title</td>
<td>AuthorID</td>
<td>publisher</td>
<td>publishdata</td>
<td>price</td>
<td>functionone</td>
<td>functiontwo</td>
</tr>
<c:forEach var="item" items="${list1}" varStatus="status">
      <tr>
      <td>${item.iSBN}</td>
      <td>${item.title}</td>
      <td>${item.authorID}</td>
      <td>${item.publisher}</td>
      <td>${item.publishdata}</td>
      <td>${item.price}</td>
      <td><s:a href="updatastrategy.jsp">更新</s:a></td>
      <td><a href="deletebook.action?iSBN=${item.iSBN}">删除</a></td>
      </tr>
</c:forEach>
</table>
</fieldset>
<br>
<br>
<br>
<fieldset>
<legend align="top">作者的详细信息：</legend>
<table align="center" border="1">
<tr>
<td>AuthorID</td>
<td>name</td>
<td>age</td>
<td>country</td>
</tr>
<c:forEach var="item" items="${list2}" varStatus="status">
      <tr>
      <td>${item.authorID}</td>
      <td>${item.name}</td>
      <td>${item.age}</td>
      <td>${item.country}</td>
      </tr>
</c:forEach>
</table>
</fieldset>   
</form>	
<p><s:a href="#" onclick="history.back()">点击此处返回上一级</s:a></p>
<p><s:a href="directory.jsp">点击此处返回功能选择界面！</s:a></p>
<p><s:a href="index.jsp">点击此处返回登录界面！</s:a></p>
</body>
</html>