<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新书上架</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">	
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/themes/icon.css">	
	<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/jquery.validate.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/jquery.validate.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>/My97Date/WdatePicker.js"></script>
	<script type="text/javascript">
	function addBook(){
		var isbn = $("#isbh").val();
		var bname = $("#bname").val();
		var press = $("#press").val();
		var pdate = $("#pdate").val;
		var price = $("#price").val;
		var outline = $("#outline").val;
		$.ajax({
			type : "post",
			url : "back/addbook.do",
			data :{},
			success : function(msg){
			
			
			}
		});
		
		
	
	
	
	
	}
	
	</script>
  </head>
  
  <body>
    <table align="center" width=90%>
      <jsp:include page="bhead.jsp"></jsp:include>   	
      <tr><td align="left"><h2>新书上架</h2></td></tr>
      <tr>
      	<td>
      	<form action="<%=basePath%>back/addbook.do" method="post" enctype="multipart/form-data">
      		<table border="0" width=60% align="center">  		
      			<tr>
      				<td>书号ISBN</td>
      				<td><input type="text" name="isbn" id="isbn"/></td>
      			</tr>
      			
       			<tr>
       				<td>书名</td>
       				<td><input type="text" name="bname" id="bname"/><span id="NameNull"></span></td>
       			</tr> 
       			      			
       			<tr>
       				<td>出版社</td>
       				<td><input type="text" name="press" id="press"/></td>
       			</tr>
       			
       			<tr>
       				<td>出版日期</td>
       				<td><input type="text" class="wdate" id="pdate" name="pdate"  onclick="WdatePicker({dateFmt:'yyyy/MM/dd'})" /></td>
       			</tr>
       			
       			<tr>
       				<td>价格</td>
       				<td><input type="text" name="price" id="price" /></td>
       			</tr>
       			
       			<tr>	
       				<td>概要</td>
       				<td>
       				<textarea rows="10"  id="outline" name="outline">
						
				    </textarea>
       				
       				</td>
       			</tr>
       			<tr>	
       				<td>图片上传</td>
       				<td><input type="file" name="pic2"/></td>
       			</tr>
       			
       			<tr>
       				<td colspan=2 align=center><input type=submit value=提交 />${msg}</td>
       			</tr>
    		</table>
    	</form>
      	</td>
      </tr>
    </table>
  </body>
</html>
