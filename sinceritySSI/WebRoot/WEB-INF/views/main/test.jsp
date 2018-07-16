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
    
    <title>My JSP 'BookAdd.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">	
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/themes/icon.css">	
	<script type="text/javascript" src="<%=basePath%>js/jquery-2.1.4.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
  </head>
  
  <body>
  		<div>
  			<h1 style="text-align: center">功能测试</h1>
  		</div>
  	  <table align="center" width="90%">
 		<tr>
 			 <td>
  			<select>
					<c:forEach items="${province}" var="xzqh" >
						<option  value="${xzqh.code_p}">${xzqh.name}</option>
					</c:forEach>
			</select>
  			 </td>
		</tr>		 
    </table>
    <div id="reg">  
<form name="formUser">
    <br>
    <table width="100%" align=center border=0>
        <tbody>
        <tr><td align=right width="15%"><STRONG>基本信息</STRONG></td></tr>
        <tr>
            <td align=right width="15%"><STRONG>用户名:</STRONG></td>
            <td width="57%">
            <input id="username" onblur="checkUserName(this)" name="username">
                <span id="username_notice" >*</span></td>
        </tr>
        <tr>
            <td align=right width="15%"><STRONG>性别:</STRONG></td>
            <td width="57%">
            <input id="man" type="radio" checked="checked" name="sex" />男<input id="woman" type="radio"  name="sex"/>女
        </tr>
       
        <tr>
            <td align=right><strong>邮箱:</strong></td>
            <td><input id="email" onblur="checkEmail(this)" name="email">
                <span id=email_notice >*</span></td>
        </tr>
        <tr>
            <td align=right><strong>密码:</strong></td>
            <td><input id="password" onblur="checkPassword(this)"
                       onkeyup="checkIntensity(this.value)" type="password" name="password">
                <span
                        id=password_notice >*</span></td>
        </tr>
        <tr>
            <td align=right><strong>密码强度:</strong></td>
            <td><table cellspacing=0 cellpadding=1 width=145 border=0>
                <tbody>
                <tr align=middle>
                    <td id=pwd_lower width="33%">弱</td>
                    <td id=pwd_middle width="33%">中</td>
                    <td id=pwd_high width="33%">强</td>
                </tr>
                </tbody>
            </table></td>
        </tr>
        <tr>
        <td align=right><strong>所属省份:</strong></td>
        <td>	
        	<select>
					<c:forEach items="${province}" var="xzqh" >
						<option  value="${xzqh.code_p}">${xzqh.name}</option>
					</c:forEach>
			</select>
        	 

        </td>
        
        
        
        </tr>
        <tr>
            <td align=right><strong>确认密码:</strong></td>
            <td><input id="conform_password" onblur="checkConformPassword(this)"
                       type="password" name="confirm_password">
                <span id=conform_password_notice >*</span></td>
        </tr>
         <tr><td align=right width="15%"><STRONG>实名信息</STRONG></td></tr>
        
        <tr>
            <td> </td>
            <td><label>
                <input type="checkbox" id="agreement" onclick="checkAgreement(this)">
                <b>我已看过并接受《<a href="http://www.baidu.com">用户协议</a>》<span id=agreement_notice >*</span></b></label></td>
        </tr>
        <tr>
            <td  ><input type=hidden value=act_register name=act></td>
            <td  ><input type=submit value=确认注册    name="Submit1" class="anniu" disabled></td>
        </tr>
        <tr>
            <td colspan=2> </td>
        </tr>
        </tbody>
    </table>
</form>
</div> 
  </body>
  
  <script>
  
  
  
  </script>
</html>
