<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>主页面</title>
</head>
<body>
	普通用户可访问<a href="<%=request.getContextPath()%>/user/info.jsp" target="_blank">用户信息页面</a>  
	<br/>  
	<br/>  
	管理员可访问<a href="<%=request.getContextPath()%>/admin/listUser.jsp" target="_blank">用户列表页面</a>  
	<br/>  
	<br/>  
	<a href="<%=request.getContextPath()%>/login/logout" target="_blank">Logout</a>
</body>
</html>