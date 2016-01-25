<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>登陆</title>
</head>
<body>
	<div style="color:red; font-size:22px;">${message_login}</div>  
   
	<form action="<%=request.getContextPath()%>/login/loginUser" method="POST">  
	    姓名：<input type="text" name="username"/><br/>  
	    密码：<input type="text" name="password"/><br/> 
	      <input type="submit" value="确认"/>  
	</form>
</body>
</html>