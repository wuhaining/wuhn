<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/externalPages/common/bootstrap.jsp" %>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登陆页面</title>
    <link href="<%=basePath%>resources/css/externalPages/login/login.css" rel="stylesheet">
	<!-- 公共样式 -->
	<link rel="stylesheet" href="<%=basePath%>resources/css/common/common.css">
  </head>
  
  <body>
  	<!-- 导航栏 
    <iframe frameborder="0" scrolling="no" width="100%" src="<%=basePath%>externalPages/common/navigation.jsp"></iframe>
    -->
    <jsp:include page="/externalPages/common/navigation.jsp"></jsp:include>
    
    <div class="container text-center loginContainer">
  		<form class="form-horizontal loginForm" action="<%=path%>/login" method="post">
  			<div class="form-group">
			    	<div class="input-group">
				      <span class="input-group-addon" id="basic-addon1"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></span>  					
				      <input type="text" class="form-control" id="inputName" placeholder="请输入账号" aria-describedby="basic-addon1">		      
			    	</div>
			</div>
		  <div class="form-group">
		    	<div class="input-group">
				    <span class="input-group-addon" id="basic-addon2"><span class="glyphicon glyphicon-lock" aria-hidden="true"></span></span>  					
		      		<input type="password" class="form-control" id="inputPassword" placeholder="请输入密码" aria-describedby="basic-addon2">
		      	</div>
		  </div>
		  <div class="form-group">
		      <button type="button" class="btn btn-primary btnSubmit">登陆</button>
		  </div>
		  <div class="form-group">
		  	<a target="_blank" href="<%=basePath%>externalPages/register/register.jsp">没有账号？立刻注册</a>
		  </div>
  		</form> 	
  	</div>
    
    
	<!-- 底部footer -->
	<iframe frameborder="0" scrolling="no" width="100%" src="<%=basePath%>externalPages/common/footer.jsp"></iframe>
  	
    
  </body>
</html>
