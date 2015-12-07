<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP '01.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/common.css" />
	<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
	<script type="text/javascript">
		$(function(){
			$(".thumbs a").click(function(){
				var largePath  = $(this).attr("href");
				var largeAlt = $(this).attr("title");
				$("#largeImg").attr({
					src : largePath,
					alt : largeAlt
				});
				return false;
			});
			
		});	
	</script>
  </head>
  
  <body>
	<h2>文件批量上传	</h2>
  	<form action="smartUploadServlet.do" method="post" enctype="multipart/form-data">
  		上传文件1：<input type="file" name="myfile1"><br>
  		上传文件2：<input type="file" name="myfile2"><br>
  		上传文件3：<input type="file" name="myfile3"><br>
  		<input type="submit" value="提交">${result}
  	</form>
  	<hr>
  	 <!-- 下载：<a href="smartDownloadServlet.do?filename=img2-lg.jpg">img2-lg.jpg</a> -->
  	 <h2>文件批量下载</h2>
  	 <form action="batchDownloadServlet.do">
  	 	<input type="checkbox"  name="filename" value="img2-lg.jpg">Image2
  	 	<input type="checkbox"  name="filename" value="img3-lg.jpg">Image3
  	 	<input type="checkbox"  name="filename" value="img4-lg.jpg">Image4
  	 	<input type="submit" value="下载">
  	 </form> 
  	<hr>
    <h2>图片预览</h2>
    <p><img id="largeImg" src="images/img1-lg.jpg" alt="Large Image"/></p>
    <p class="thumbs">
    	<a href="images/img2-lg.jpg" title="Image2"><img src="images/img2-thumb.jpg"></a>
    	<a href="images/img3-lg.jpg" title="Image3"><img src="images/img3-thumb.jpg"></a>
    	<a href="images/img4-lg.jpg" title="Image4"><img src="images/img4-thumb.jpg"></a>
    	<a href="images/img5-lg.jpg" title="Image5"><img src="images/img5-thumb.jpg"></a>
    	<a href="images/img6-lg.jpg" title="Image6"><img src="images/img6-thumb.jpg"></a>
    </p>
  </body>
</html>
