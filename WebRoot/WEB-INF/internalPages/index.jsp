<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理主页面</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	

  </head>
  
  <body>
   	 管理主页面<br>
   	 <p>${msg}</p>
  </body>
</html>
