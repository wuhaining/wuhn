<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登陆页面</title>
    

  </head>
  
  <body>
    <form action="<%=path%>/login" method="post">
    	<p>
    		账号：<input type="text" name="name" />
    	</p>
    	<p>
    		密码：<input type="text" name="password"/>
    	</p>
    	<input type="submit" value="提交" />
    </form>
  </body>
</html>
