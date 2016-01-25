<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>
<body>
	当前登录的用户为${currUser}  
	<br/>  
	<br/>  
	<a href="<%=request.getContextPath()%>/login/logout" target="_blank">Logout</a>
</body>
</html>