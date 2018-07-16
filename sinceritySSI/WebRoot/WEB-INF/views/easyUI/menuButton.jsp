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
	<script type="text/javascript">  
	  $(document).ready(function(){  
	  debugger;
  	$('#province').combobox({
    url:'<%=basePath%>easyui/province.do',
    valueField:'code_p',
    textField:'name',
    multiple:false,
    onSelect : function(){
    	$("#area").combobox("clear"); 
 		$('#area').combobox('loadData', {});
    	loadcity();
    }
	});
	 }); 
	 function loadcity(){
	
	 var code_p = $("#province").combobox("getValue");
	 	$('#city').combobox({
    url:'<%=basePath%>easyui/city.do?code_p='+code_p,
    valueField:'code_c',
    textField:'name',
    multiple:false,
    onSelect : function(){
    	loadarea();
    }
	});
 }	
 	function loadarea(){
 	var code_c = $("#city").combobox("getValue");
 			$('#area').combobox({
    url:'<%=basePath%>easyui/area.do?code_c='+code_c,
    valueField:'code_a',
    textField:'name',
    multiple:true
	});
 }
	 
	</script>  
  </head>
  
  <body>
  <!-- <form>
  <table>
  		<tr>
  			<td>  	
  				<select id="province" class="easyui-combobox" name="province" style="width:200px;" data-options="multiple:false,panelHeight:'auto'"></select>
 			</td>
  			<td>    
  				<select id="city" class="easyui-combobox" name="city" style="width:200px;" data-options="multiple:false,panelHeight:'auto'"></select>
  			</td>
  			<td>    
  				<select id="area" class="easyui-combobox" name="area" style="width:200px;" data-options="multiple:false,panelHeight:'auto'"></select>
 			</td>
 	    </tr>
  </table>
 </form> -->
 
 
 <input type="button" value="添加" onclick="addNew();"> 
<input type="button" value="删除" onclick="del();"> 
<div id="rightcontent"> 
<table id="table1" cellspacing="3" cellpadding="3" border="1"> 
<tbody> 
<tr>
  			<td>  	
  				<select id="province" class="easyui-combobox" name="province" style="width:200px;" data-options="multiple:false,panelHeight:'auto'"></select>
 			</td>
  			<td>    
  				<select id="city" class="easyui-combobox" name="city" style="width:200px;" data-options="multiple:false,panelHeight:'auto'"></select>
  			</td>
  			<td>    
  				<select id="area" class="easyui-combobox" name="area" style="width:200px;" data-options="multiple:false,panelHeight:'auto'"></select>
 			</td>
 	    </tr> 
</tbody> 
</table> 
</div> 
  
             	
  </body>
<script>
	var i = 1;
	var row_count = 0; 
	function addNew() { 
	debugger;
			row_count++; 
		var table1 = $('#table1'); 
		/* var firstTr = table1.find('tbody>tr:first'); 
		var row = $("<tr></tr>"); 
		var td = $("<td>"+row_count+"</td>"); 
			td.append($("<input type='checkbox' name='count' value='New'>")); 
			td.append("<input type='text' name='count'+row_count >") ;
			td.append("<input type='button' value='删除' onclick='delRow(this)'>") ;
			row.append(td); 
			table1.append(row);  */
		var tr = $("<tr><td>"
		+"<select id=\"province"+i+"\" class=\"easyui-combobox\" name=\"province\" style=\"width:200px;\" data-options=\"multiple:false,panelHeight:'auto'\">"
		+"</select></td>"
		+"<td><select id=\"city"+i+"\" class=\"easyui-combobox\" name=\"city\" style=\"width:200px;\" data-options=\"multiple:false,panelHeight:'auto'\">"
		+"</select></td>"
		+"<td><select id=\"area"+i+"\" class=\"easyui-combobox\" name=\"area\" style=\"width:200px;\" data-options=\"multiple:false,panelHeight:'auto'\">"
		+"</select></td></tr>");
		table1.append(tr);
		
		addloadprovince();
		} 
		function addloadprovince(){
			var count=i+"";
		$('#province'+i).combobox({
    url:'<%=basePath%>easyui/province.do',
    valueField:'code_p',
    textField:'name',
    multiple:false,
    onSelect : function(){
     $('#area'+count).combobox({
 	loadData:  {},
 	 valueField:'code_c',
    textField:'name'
	}); 
	
	
	// $('#area'+count).combobox("clear"); 
 	//$('#area').combobox('loadData', {}); 
    	addloadcity(count);
    }
	});
	i++;
		
		
		}
		 function addloadcity(count){
		 
	 var code_p = $("#province"+count).combobox("getValue");
	 	$('#city'+count).combobox({
    url:'<%=basePath%>easyui/city.do?code_p='+code_p,
    valueField:'code_c',
    textField:'name',
    multiple:false,
    onSelect : function(){
    
    	addloadarea(count);
    }
	});
 }	
 	function addloadarea(count){
 	var code_c = $("#city"+count).combobox("getValue");
 			$('#area'+count).combobox({
    url:'<%=basePath%>easyui/area.do?code_c='+code_c,
    valueField:'code_a',
    textField:'name',
    multiple:true
	});
 }
		
		
		
		
	function delRow(obj){ 
		$(obj).parent().remove(); 
		}
		function del(){ 
		debugger;
			/* var checked = $("input[type='checkbox'][name='count']"); 
			$(checked).each(function(){ 
			alert(checked);
			alert($(this).attr("checked"));
			if($(this).attr("checked")== true){  //注意：此处判断不能用$(this).attr("checked")==‘true'来判断。 
				$(this).parent().parent().remove(); 
				} 
			});  */
			
			 $("input[type='button']").click(function() {
       		 $("input[name='count']:checked").each(function() { // 遍历选中的checkbox
            n = $(this).parents("tr").index();  // 获取checkbox所在行的顺序
            $("table#table1").find("tr:eq("+n+")").remove();
        });
    });
		}  



</script>
 	
      
  
</html>
