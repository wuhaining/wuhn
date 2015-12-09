<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>批量下载</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    	<h3>批量下载</h3>
    	<form action="<%=path %>/BatchSmartDownloadServlet.do" method="post">
	    	<input type="checkbox" name="filename" value="jplugin-css.jpg"/>jplugin-css.jpg<br>
	    	<input type="checkbox" name="filename" value="jplugin-multiple.jpg"/>jplugin-multiple.jpg<br>
	    	<input type="checkbox" name="filename" value="jplugin-nocss.jpg"/>jplugin-nocss.jpg<br>
	    	
	    	<input type="submit" value="提交">
    	</form>
    	
    	
  </body>
</html>
