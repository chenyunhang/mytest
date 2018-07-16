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
    
    <title>EasyUI Test</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/themes/icon.css">
	<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>	
    
  </head>
  
  <body>
  
       <table align="center" width=90%>
           
            <tr>
              <td>
                 <input type="button" name="" value="datagird CRUD" 
                 onclick="javascript:window.location='<%=basePath%>easyui/datagrid.do';" />
              </td>
            </tr>
            
            <tr>
              <td>
                 <input type="button" name="" value="菜单与按钮" 
                 onclick="javascript:window.location='<%=basePath%>easyui/menuButton.do';" />
              </td>
            </tr>
            <tr>
              <td>
                 <input type="button" name="" value="上传" 
                 onclick="javascript:window.location='<%=basePath%>easyui/uploadfy.do';" />
              </td>
            </tr>
            
            <tr>
              <td>
                 <input type="button" name="" value="查看" onclick="ck()" />
              </td>
            </tr>
            
            <tr>
              <td>
                 <input type="button" name="" value="jsonUtil" 
                 onclick="javascript:window.location='<%=basePath%>easyui/jsonUtil.do';" />
              </td>
            </tr>
       </table>         	
  </body>
  <script type="text/javascript">
  
  
  
  
  </script>
</html>
