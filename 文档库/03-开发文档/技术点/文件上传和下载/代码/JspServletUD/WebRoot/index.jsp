<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>上传</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=path%>/css/common.css">
	<script type="text/javascript" src="<%=path%>/js/jquery-1.11.1.js"></script>
	
  </head>
  
  <body>
    <a href="<%=path%>/jsp/01.jsp" target="_blank">上传01</a>
    <br>
    <a href="<%=path%>/jsp/02.jsp" target="_blank">下载02</a>
  </body>
</html>
