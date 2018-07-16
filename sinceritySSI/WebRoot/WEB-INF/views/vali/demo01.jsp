<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <base href="<%=basePath%>">
    <title>jquery validate验证</title>
    <script type="text/javascript" src="<%=basePath%>/js/jquery-2.1.4.min.js" ></script>
    <script type="text/javascript" src="<%=basePath%>/js/validate/jquery.validate.js"></script>
    <script type="text/javascript">
    	$(function(){
    		//让当前表单调用validate方法，实现表单验证功能
    		$("#ff").validate({
    			debug:true	//调试模式，即使验证成功也不会跳转到目标页面
    		});
    	});
    </script>
  </head>
  
  <body>
  	<ul>
  		<li>搭建validate验证框架
  	</ul>
    <form id="ff" action="http://www.hao123.com" method="post">
    	<input type="submit" value="提交">
    </form>
  </body>
</html>
