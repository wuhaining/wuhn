<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/externalPages/common/bootstrap.jsp" %>
<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>首页</title>
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
  	<!-- 导航栏 -->
    <iframe frameborder="0" scrolling="no" width="100%" src="<%=basePath%>externalPages/common/navigation.jsp"></iframe>
	<!-- 底部footer -->
	<iframe frameborder="0" scrolling="no" width="100%" src="<%=basePath%>externalPages/common/footer.jsp"></iframe>
  </body>
</html>
