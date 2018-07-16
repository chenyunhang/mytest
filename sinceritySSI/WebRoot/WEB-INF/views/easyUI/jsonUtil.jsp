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
  	<table  border="1" cellpadding="0" id="zb">
  	<tr>
  	<td>姓名</td>
  	<td>${zb.xm}</td>
  	</tr>
  	<tr>
  	<td>账号</td>
  	<td>${zb.zh}</td>
  	</tr>
  	</table>
 
 

  
             	
  </body>
<script type="text/javascript">
  $ajax({
  		type : 'post',
        url :  url,
        data : $( '#fm').serialize(),
        	success : function(data){
							alert("初始化成功");
							}
       });

</script>
 	
      
  
</html>
