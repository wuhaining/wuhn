<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>富文本编辑器</title>
    <meta charset="utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<!--ckeditor  -->
	<script type="text/javascript" src="<%=path%>/ckeditor/ckeditor.js"></script>		
	<!--ckefinder  -->
	<script type="text/javascript" src="<%=path%>/ckfinder/ckfinder.js"></script>		
	
	
  </head>
  
  <body>
    <h1>富文本编辑器</h1>
    
    <form action="" method="post">
    	<textarea rows="10" cols="80" id="editor" name="editor" class="ckeditor">请输入...</textarea>
    	<input type="submit" value="保存"/>
    </form>
  </body>
</html>
