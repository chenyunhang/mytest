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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=basePath%>/js/jquery-2.1.4.min.js" ></script>
<script type="text/javascript" src="<%=basePath%>/js/jquery.easyui.min.js" ></script>
<script type="text/javascript" src="<%=basePath%>/js/personal/registerCheck.js" ></script>
<script type="text/javascript" src="<%=basePath%>/js/personal/xzqhThreeLevelLink.js" ></script>
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
 <script type="text/javascript" src="<%=basePath%>/My97Date/WdatePicker.js"></script>
 <script type="text/javascript">
 	function submitUser(){
 	debugger;
 			var uname = $("#username").val();
 			var account = $("#account").val();
 	//		var sex = $("input[type='radio']:checked").val();
 			var birth = $("#birth").val();
 			var sex = $("input[name='sex']:checked").val();
 			alert(sex);
 			var email = $("#email").val();
 			var pwd = $("#password").val();
 			var province = $("#province").val();
 			var city = $("#city").val();
 			var area = $("#area").val();
 			
 			$.ajax({
 			type: "post",
 			url:"user/regist.do",
 			data:{
 				uname : uname,
 				pwd : pwd,
 				account : account,
 				sex : sex,
 				birth : birth,
 				email : email,
 				province : province,
 				city : city,
 				area : area
 			
 			},
 			dateType:"json",
 			success: function(msg){
 				alert("提交成功")
 			}
 			});
 	};
 
 </script>
<title>用户注册</title>
</head>
<body>  
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
            <td align=right width="15%"><STRONG>充值:</STRONG></td>
            <td width="57%">
            <input type="text" id="account"  name="account">
               
        </tr>
        <tr>
            <td align=right width="15%"><STRONG>性别:</STRONG></td>
            <td width="57%">
            <input id="man" type="radio" checked="checked" name="sex" value="0"/>男<input id="woman" type="radio"  name="sex" value="1"/>女
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
            <td align=right><strong>确认密码:</strong></td>
            <td><input id="conform_password" onblur="checkConformPassword(this)"
                       type="password" name="confirm_password">
                <span id=conform_password_notice >*</span></td>
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
            <td align=right width="15%"><STRONG>出生年月:</STRONG></td>
            <td width="57%">
            <input type="text" class="wdate" id="birth" name="birth"  onclick="WdatePicker({dateFmt:'yyyy/MM/dd'})" />
            </td>
        </tr>
        
         <tr>
            <td align=right width="15%"><STRONG>注册时间:</STRONG></td>
            <td width="57%">
            <input type="text" class="wdate" name="newsTime"  onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
            </td>
        </tr>
        
        <tr>
        <td align=right><strong>所属省份:</strong></td>
        <td>	
        	<select id="province" name="province" onchange="getAllCity()" style="width: 160px;">
        	<option  value="">--请选择--</option>
			</select>
        </td>
        </tr>
        
        <tr>
        <td align=right ><strong>所属市级:</strong></td>
        <td width="57%">	
        	<select id="city"  name="city" onchange="getAllArea()" style="width: 160px;">
        	<option>--请选择--</option>
			</select>
        </td>
        </tr>
        <tr>
        <td align=right ><strong>所属区级:</strong></td>
        <td>	
        	<select id="area"  name="area" style="width: 160px;">
        	<option>--请选择--</option>
			</select>
        </td>
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
            <td  ><input type="button" value=确认注册    name="Submit1" class="anniu" disabled  onclick="submitUser()"></td>
        </tr>
        <tr>
            <td colspan=2> </td>
        </tr>
        </tbody>
    </table>
</form>
</div> 
   
</body>
</html>