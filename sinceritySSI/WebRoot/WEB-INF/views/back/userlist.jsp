<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

     <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'userlist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/themes/icon.css">
	<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>	
    <script type="text/javascript">
    	$(function(){
    		$('#tt').datagrid({
				title:'用户列表',							
				height:350,
				nowrap: false,
				striped: true,								
				url: '<%=basePath%>user/userlist.do',
				rownumbers:true,
				loadMsg : 'processing, please wait …',			
				columns:[[					
					{field:'uname',title:'用户名'},					
					{field:'account',title:'账户金额',width:100},					
					{field:'role',title:'角色',width:180},
					{field:'pwd',title:'密码',width:180}				
				]]					
			});						
    	});     	
    </script>
  </head>
  
  <body>
       <table align="center" width=100% border="1">
            	 <jsp:include page="bhead.jsp"></jsp:include>  
            <tr>
              <td>
                  <table id="tt"></table>    	
              </td>
            </tr>
       </table> 
       <div  align="left" > 
  		&nbsp&nbsp	<a>增加用户</a>&nbsp&nbsp&nbsp<a>删除用户</a>&nbsp&nbsp&nbsp<a>用户修改</a>&nbsp&nbsp&nbsp<a>用户查询</a>
  		</div>
  		
  		<form action="<%=basePath%>user/userlist.do" method="post">
      		<table>
      		   <tr><td align=left>用户名 </td><td><input type="text" name="uname" value="${uname}"/></td></tr>
                <td><input type=submit value="查询"/></td>
      		</table>
      		</form>
              <table align="center" width=100% border="1">
              <tr>
 				  <th>用户名</th>
  				  <th>账户金额</th>
  				  <th>密码</th>
 				  <th>角色</th>    
  			 </tr>
  			 <c:forEach items="${userList}" var="user" >
				<tr>
					<td><input type="text" style="width: 100%;" value="${user.UNAME}"/></td>
					<td><input type="text" style="width: 100%;" value="${user.ACCOUNT}"/></td>
					<td><input type="text" style="width: 100%;" value="${user.PWD}"/></td>
					<td><input type="text" style="width: 100%;" value="${user.ROLE}"/></td>
				</tr>				
			</c:forEach>
              </table>
     </body>
    
    
</html>
