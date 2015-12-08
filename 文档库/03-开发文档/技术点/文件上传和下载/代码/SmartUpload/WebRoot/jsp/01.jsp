<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>SmartUpload_批量上传</title>
    
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
    <form action="<%=path%>/SmartUploadServlet.do" method="post" enctype="multipart/form-data">
  		上传文件1：<input id="myfile1" name="myfile1" type="file"/><br>
  		上传文件2：<input id="myfile2" name="myfile2" type="file"/><br>
  		上传文件3：<input id="myfile3" name="myfile3" type="file"/>
  		<input type="submit" value="提交"  />&nbsp;&nbsp;${result}
  	</form>
  </body>
</html>
