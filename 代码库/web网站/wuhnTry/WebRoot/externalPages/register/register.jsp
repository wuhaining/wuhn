<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/externalPages/common/bootstrap.jsp" %>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="<%=basePath%>resources/css/externalPages/register/register.css" rel="stylesheet">
	<!-- 公共样式 -->
	<link rel="stylesheet" href="<%=basePath%>resources/css/common/common.css">

  </head>
  
  <body>
    <!-- 导航栏
    <iframe frameborder="0" scrolling="no" width="100%" src="<%=basePath%>externalPages/common/navigation.jsp"></iframe>
     -->
    <jsp:include page="/externalPages/common/navigation.jsp"></jsp:include>
    
    <div class="container text-left regitsterContainer">
    	<form class="form-horizontal regitsterForm" action="" method="post">
    	  <div class="form-group has-error has-feedback">
		    <label for="inputNickname" class="col-sm-2 control-label">昵称</label>
		    <div class="col-sm-5">
		      <input type="text" name="" class="form-control" id="inputNickname" placeholder="请输入昵称">
		      <span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true"></span>
  			  <span id="inputError2Status" class="sr-only">(error)</span>
		    </div>
		    <div class="col-sm-5">
		    
		    </div>
		  </div>
		  
		  <div class="form-group has-success has-feedback">
		    <label for="inputNickname" class="col-sm-2 control-label">电子邮箱</label>
		    <div class="col-sm-5">
		      <input type="text" name="" class="form-control" id="inputNickname" placeholder="请输入你的电子邮箱">
		      <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
  			  <span id="inputSuccess2Status" class="sr-only">(success)</span>
		    </div>
		    <div class="col-sm-5">
		    
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label for="inputPassword" class="col-sm-2 control-label">密码</label>
		    <div class="col-sm-5">
		      <input type="password" class="form-control" id="inputPassword" placeholder="请输入密码">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="confirmPassword" class="col-sm-2 control-label">确认密码</label>
		    <div class="col-sm-5">
		      <input type="password" class="form-control" id="confirmPassword" placeholder="请再一次输入密码">
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-5">
		      <button type="button" class="btn btn-info btn-block">注册</button>
		    </div>
		  </div>
    	</form>
    </div>
    
	<!-- 底部footer -->
	<iframe frameborder="0" scrolling="no" width="100%" src="<%=basePath%>externalPages/common/footer.jsp"></iframe>
  </body>
</html>
