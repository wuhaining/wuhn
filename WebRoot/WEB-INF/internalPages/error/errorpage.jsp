<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>业务异常界面error page</title>
    
	<script type="text/javascript" src="<%=path%>/resources/JavaScript/common/jquery-1.11.3.min.js"></script> 
	<script type="text/javascript">
		 $(function(){  
            $("#center-div").center(true);  
         });  
	</script>


  </head>
  
  <body style="margin: 0;padding: 0;background-color: #f5f5f5;">  
    <div id="center-div">  
        <table style="height: 100%; width: 600px; text-align: center;">  
            <tr>  
                <td>  
                <img width="220" height="393" src="<%=path%>/images/common/error.png" style="float: left; padding-right: 20px;" alt="" /> 
                	<pre>${message}</pre>
                    <p style="line-height: 12px; color: #666666; font-family: Tahoma, '宋体'; font-size: 12px; text-align: left;">  
                    <a href="javascript:history.go(-1);">返回</a>!!!  
                    </p>  
                </td>  
            </tr>  
        </table>  
    </div>  
</body>  
</html>
