<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

 <tr>
      	<td align=right>
      	    
      	  		管理员: admin &nbsp;	  		       	         	    	         	          	  	
      		
      			<a href="#">退出</a>
      		      	
      	</td>       	
      </tr>
      <tr>
      	<td align=center>
      	    <a href="<%=basePath%>back/addbook.do">新书上架</a> &nbsp;  <a href="#">书增加库存</a>  &nbsp;  <a href="#">书下架</a> &nbsp;  <a href="<%=basePath%>user/userlist.do">用户管理</a>
      	    &nbsp;  <a href="#">修改售价</a> &nbsp; <a href="<%=basePath%>back/buyrecord.do">用户购买记录</a>
      	</td>
      	</tr> 
