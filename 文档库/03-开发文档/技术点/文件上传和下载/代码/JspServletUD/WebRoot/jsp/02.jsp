<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>下载</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=path%>/css/common.css">
	<script type="text/javascript" src="<%=path%>/js/jquery-1.11.1.js"></script>

  </head>
  
  <body>
    下载：<a href="<%=path%>/DownloadServlet.do?filename=test.txt">test.txt</a>&nbsp;&nbsp;&nbsp;&nbsp;${errorResult}
  </body>
</html>
