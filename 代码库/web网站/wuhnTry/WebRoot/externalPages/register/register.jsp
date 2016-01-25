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
	<!-- jqueryValidate样式 -->
	<link rel="stylesheet" href="<%=basePath%>resources/plugIn/jqueryValidation/css/validate.css">
	
	
	<!-- jquery自定义-->
	<script src="<%=basePath%>resources/JavaScript/common/jqueryValidate.js"></script>
	 
	
	<script type="text/javascript">
	$(function(){
		/***jqueryValidate校验***/	
		$("#registerId").validate();
		 
	});
	</script>
  </head>
  
  <body>
    <!-- 导航栏
    <iframe frameborder="0" scrolling="no" width="100%" src="<%=basePath%>externalPages/common/navigation.jsp"></iframe>
     -->
    <jsp:include page="/externalPages/common/navigation.jsp"></jsp:include>
    
    <div class="container text-left regitsterContainer">
    	<form id="registerId" class="form-horizontal regitsterForm" action="<%=basePath%>" method="post">
    	  <div class="form-group">
		    <label for="inputNickname" class="col-sm-2 col-sm-offset-2 control-label">昵称</label>
		    <div class="col-sm-6">
		      <input type="text" name="" class="form-control JV_Required" id="inputNickname" placeholder="请输入昵称">
		    </div>
		    <div class="col-sm-2">
		    	
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label for="inputEmail" class="col-sm-2 col-sm-offset-2 control-label">电子邮箱</label>
		    <div class="col-sm-6">
		      <input type="text" name="" class="form-control JV_Required JV_Email" id="inputEmail" placeholder="请输入你的电子邮箱">
		    </div>
		    <div class="col-sm-2">
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label for="inputPassword" class="col-sm-2 col-sm-offset-2 control-label">密码</label>
		    <div class="col-sm-6">
		      <input type="password" class="form-control JV_Required JV_Password" id="inputPassword" placeholder="请输入密码">
		    </div>
		    <div class="col-sm-2">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="confirmPassword" class="col-sm-2 col-sm-offset-2 control-label">确认密码</label>
		    <div class="col-sm-6">
		      <input type="password" class="form-control JV_Required JV_ConfirmPassword" id="confirmPassword" placeholder="请再一次输入密码">
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <div class="col-sm-offset-4 col-sm-6">
		      <button type="button" class="btn btn-info btn-block">注册</button>
		    </div>
		  </div>
    	</form>
    </div>
    
	<!-- 底部footer -->
	<iframe frameborder="0" scrolling="no" width="100%" src="<%=basePath%>externalPages/common/footer.jsp"></iframe>
  </body>
</html>
