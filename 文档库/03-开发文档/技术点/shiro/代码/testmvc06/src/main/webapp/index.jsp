<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>详细</title>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.11.3.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$("h2").click(function(){
				alert("jquery");
			});
		});
	</script>
</head>
<html>
<body>
	<h2>Hello World!</h2>
	
	
	<a href="${pageContext.request.contextPath}/login.jsp">登陆</a>
</body>
</html>
