<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP '01.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=path%>/css/common.css">
	<script type="text/javascript" src="<%=path%>/js/jquery-1.11.1.js"></script>
	<script type="text/javascript">
		$(function(){
			$(".thumbs a").click(function(){
				var localPath = $(this).attr("href");
				var localAlt = $(this).attr("title");
				
				$("#largeImg").attr({
					src:localPath,
					alt:localAlt
				});
				
				return false;
			});
		});
		
		/*//js 预览功能因为回去不到本地实际的路径，所以无法实现。因为浏览器考虑到安全性的问题，限制了获取真实的本机路径，只能这样C:\fakepath\img1-lg.jpg
		function showPreview(obj){
			var imgPath = obj.value;
			console.log(imgPath);
			document.getElementById("previewImg").innerHTML="<img src='"+imgPath+"'/>";
		}
		*/
		
	</script>

  </head>
  
  <body>
  	<form action="<%=path%>/UploadServlet.do" method="post" enctype="multipart/form-data">
  		请选择图片：<input id="myfile" name="myfile" type="file"/>
  		<input type="submit" value="提交"  />
  	</form>
  	
  	
  	<!-- 
    <h2>图片预览</h2>
    <p><img id="largeImg" src="images/img1-lg.jpg" alt="Large Image"/></p>
    <p class="thumbs">
    	<a href="images/img2-lg.jpg" title="Image2"><img src="images/img2-thumb.jpg"></a>
    	<a href="images/img3-lg.jpg" title="Image3"><img src="images/img3-thumb.jpg"></a>
    	<a href="images/img4-lg.jpg" title="Image4"><img src="images/img4-thumb.jpg"></a>
    	<a href="images/img5-lg.jpg" title="Image5"><img src="images/img5-thumb.jpg"></a>
    	<a href="images/img6-lg.jpg" title="Image6"><img src="images/img6-thumb.jpg"></a>
    </p>
     -->
  </body>
</html>
