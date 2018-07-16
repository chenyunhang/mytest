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
    
    <title>My JSP 'userlist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>js/jquery-2.1.4.min.js" >
	
	<script type="text/javascript" src="<%=basePath%>js/jquery.min.js" ></script>
	<script type="text/javascript" src="<%=basePath%>js/jquery.easyui.min.js" ></script>	
	<script type="text/javascript" src="<%=basePath%>js/easyui/easyui-lang-zh_CN.js"></script>	
    <script type="text/javascript">
   
    	 	function test(){
    	// 	$.messager.progress(); 
    	 //	$.messager.progress('close');
    	 	/* $.messager.prompt('Prompt', 'Please enter your name:', function(r){
				if (r){
				alert('Your name is:' + r);
	}
}); */
    	// 	$.messager.alert('My Title','Here is a info message!','info');
    		$.messager.alert('提示:','用户已经成功添加!','info');				
    	 		/* $.messager.show({
	title:'My Title',
	msg:'Message will be closed after 5 seconds.',
	timeout:5000,
	showType:'slide'
}); */
// show message window on top center
/* $.messager.show({
	title:'My Title',
	msg:'Message will be closed after 4 seconds.',
	showType:'show',
	style:{
		right:'',
		top:document.body.scrollTop+document.documentElement.scrollTop,
		bottom:''
	}
}); */
    	 	
    	 	}
    </script>
  </head>
  
  <body>
  	<!--  <div id="toolbar">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">New User</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">Edit User</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser()">Remove User</a>
	</div>
       <table align="center" width=90%>
           
            <tr>
              <td>
                  <table id="tt"></table>    	
              </td>
            </tr>
       </table>  -->  
       
    <table id="mTb"  class="easyui-datagrid" width="100%"  url="<%=basePath%>easyui/userlist.do"   toolbar="#toolbar" pagination="true"
       	 rownumbers="true" fitColumns="true"   checkOnSelect = "true"
         pageSize="5"       
       	 pageList="[3,5,8,10]">
        <thead>
            <tr>
            	<th field="ck" checkbox="true"></th>
                <th field="id" width="50" data-options="hidden: true">编号</th>
                <th field="uname" width="140">姓名</th>
                <th field="pwd" width="140">密码</th>
                <th field="sex" width="140">性别</th>
                <th field="account" width="140">账户</th>
                <th field="role" width="140">角色</th>
                <th field="birth" width="180">生日</th>
                <th field="province" width="140">省</th>
                <th field="city" width="140">市</th>
                <th field="area" width="140">区</th>
                <th field="email" width="180">邮箱</th>
            </tr>
        </thead>
      </table>
      
      <div id="toolbar">
        <a  class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">新增</a>
        <a  class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">修改</a>
        <a  class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="removeUser()">删除</a>
        <a  class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="test()">测试</a>
        
    </div>
    
    <div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
            closed="true" buttons="#dlg-buttons">
        <div class="ftitle">用户信息</div>
        <form id="fm" method="post" novalidate>
            <div class="fitem">
                <label>姓名:</label>
                <input name="uname" id="sss" class="easyui-validatebox" required="true">
            </div>
            <div class="fitem">
                <label>密码:</label>
                <input name="pwd" class="easyui-validatebox" required="true">
            </div>
            <div class="fitem">
                <label>性别:</label>
                <input name="sex" class="easyui-validatebox" required="true">
            </div>
            <div class="fitem">
                <label>账户:</label>
                <input name="account" class="easyui-validatebox" required="true">
            </div>
            <div class="fitem">
                <label>角色:</label>
                <input name="role" class="easyui-validatebox" required="true">
            </div>
            <div class="fitem">
                <label>生日:</label>
                <input name="birth" class="easyui-validatebox" required="true">
            </div>
            <div class="fitem">
                <label>省:</label>
                <input name="province" class="easyui-validatebox" required="true">
            </div>
            <div class="fitem">
                <label>市:</label>
                <input name="city" class="easyui-validatebox" required="true">
            </div>
            <div class="fitem">
                <label>区:</label>
                <input name="area" class="easyui-validatebox" required="true">
            </div>
            <div class="fitem">
                <label>邮箱:</label>
                <input name="email" class="easyui-validatebox" required="true">
            </div>
        </form>
    </div>
    <div id="dlg-buttons">
        <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveUser()">提交</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
    </div>
             	
  </body>
  <script type="text/javascript">
      <%--     var url;
        function newUser(){
        debugger;
            $('#dlg').dialog('open').dialog('setTitle','新增');
            $('#fm').form('clear');
           
            url = '<%=basePath%>easyui/addUser.do';
             
        }
        function editUser(){
        debugger;
            var row = $('#mTb').datagrid('getSelected');
            alert(row.id);
            if (row){
                $('#dlg').dialog('open').dialog('setTitle','修改');
                $('#fm').form('load',row);
                url = '<%=basePath%>easyui/editUser.do?id='+row.id;
            }
        }
        function saveUser(){
        debugger;
        
        alert(url)
            $('#fm').form('submit',{
                url: url,
                onSubmit: function(){
                    return $(this).form('validate');
                },
                success: function(result){
                
                  //  var result = eval('('+result+')');
                    alert(result);
                    if (result==0){
                  
						$.messager.alert('提示:','用户已经成功添加!','info'); 
                        $('#dlg').dialog('close');        // close the dialog
                        $('#mTb').datagrid('reload');    // reload the user data
                        return;
                    } else {
                        $.messager.show({
                            title: '提示',
                            msg: result.message
                        });
                    }
                }
            });
        } --%>
       <%--  function removeUser(){
        debugger;
            var row = $('#mTb').datagrid('getSelected');
            if (row){
                $.messager.confirm('确认','您确定要删除吗？',function(r){
                    if (r){
                        $.post('<%=basePath%>easyui/delUser.do',{id:row.id},function(result){
                        debugger;
                        alert(12)
                            if (result.success){
                                $.messager.show({    // show error message
                                        title: '提示',
                                        msg: result.message
                                    });
                                $('#mTb').datagrid('reload');    // reload the user data
                            } else {
                                $.messager.show({    // show error message
                                    title: '提示',
                                    msg: result.message
                                });
                            }
                        },'json');
                    }
                });
            }
        }  --%>
        var url = "";
       function newUser(){
        debugger;
            $('#dlg').dialog('open').dialog('setTitle','新增');
            $('#fm').form('clear');
             url = '<%=basePath%>easyui/addUser.do';
        }
        function editUser(){
        debugger;
            var row = $('#mTb').datagrid('getSelected');           
            if (row){
                $('#dlg').dialog('open').dialog('setTitle','修改');
                $('#fm').form('load',row);
                url = '<%=basePath%>easyui/editUser.do?id='+row.id;
            }
        }
        function saveUser(){
          
        debugger;
        		$.ajax({
        				type : 'post',
        				url :  url,
        				data : $( '#fm').serialize(),
        				 success : function(data){
							if(data==0){
    			   				 $('#mTb').datagrid('reload');     			
    								$.messager.alert('提示:','用户已经添加成功!','info');
    								return false;
    						}else if ( data==1){
    							$.messager.alert('提示:','用户添加失败!','error');
    								return false;
    						}else if(data==2){
    						 $('#mTb').datagrid('reload'); 
    						$.messager.alert('提示:','用户已经修改成功!','info');
    								return false;
    						}else {
    						$.messager.alert('提示:','用户修改失败!','error');
    								return false;
    						}
        				 }
        		});
        } 
       function removeUser(){
       debugger;
       var row = $('#mTb').datagrid('getSelected');
        if(row){
         $.messager.confirm('确认','您确定要删除吗？', function (data) {  
            if (data) {  
              $.ajax({
         			type : 'post',
         			url : '<%=basePath%>easyui/delUser.do',
         			data : 'id='+row.id,
         			dataType : 'json',
         			success: function(data){//如果调用成功
    			if(data==0){
    			    $('#mTb').datagrid('reload');     			
    				$.messager.alert('提示:','用户已经成功删除!','info');
    			}else {
    				$.messager.alert('提示:','删除用户失败!','error');
    			}
    		} 
         			});
            }  
           
        });  
         }
     }
		
		 function doSearch(){
            $('#mTb').datagrid('load',{
                name: $('#username').val(),
                xueli: $('#userxueli').val()
            });
        }
        
  </script>

      
  
</html>
