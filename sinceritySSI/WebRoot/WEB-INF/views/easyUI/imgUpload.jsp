<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>菜单与按钮</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>js/jquery-2.1.4.min.js" >
	
	<script type="text/javascript" src="<%=basePath%>js/jquery.min.js" ></script>
	<script type="text/javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>	
	<script type="text/javascript" src="<%=basePath%>js/easyui/easyui-lang-zh_CN.js"></script>	

  </head>
  
  <body>
 <div id="main_box">
	<form id="uploadImg" action="" method="post" enctype="multipart/form-data">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<input type="hidden" name="picturetype" value="${picturetype}" id="currentpicType"/>
			  <input type="text" name="picturename" class="required pfinput" value="" id="picturename">
				上传图片<input type="file" name="file" class="" id="file_browse" onChange="getURL(this)">
	<input type="hidden" id="imgSize" value=""/>
	<input type="hidden" name="path" class="pfinput" value="" disabled="disabled" id="localpath">
	<span class="upload_btn" id="browse" style="display:none">浏览...</span>
	</form>
</div>
       
       
       
             	
  </body>

 	
      
  
</html>
