$(document).ready(function(){  
	debugger;
       		$.ajax({
 			type: "post",
 			url:"xzqh/province.do",
 			//data:"code_c="+code_c,
 			dateType:"json",
 			success: function(json){
 				 var provinceXx = JSON.parse(json); 
 				var str = "<option>请选择</option>";
							for ( var i = 0; i < provinceXx.length; i++) {
							
								 str += "<option value='" + provinceXx[i].code_p
										+ "'>" + provinceXx[i].name
										+ "</option>"; 
							}
							 $("#province").append(str);
							
 			}
 			});
    }); 

 	function getAllCity(){
 	debugger;
 			var code_p = document.getElementById("province").value;
 			$.ajax({
 			type: "post",
 			url:"xzqh/city.do",
 			data:"code_p="+code_p,
 			dateType:"json",
 			success: function(json){
 				var cityXx = JSON.parse(json);  
 				var str = "<option>--请选择--</option>";
							$("#city").html("");
							for ( var i = 0; i < cityXx.length; i++) {
							
								 str += "<option value='" + cityXx[i].code_c
										+ "'>" + cityXx[i].name
										+ "</option>"; 
							}
							 $("#city").append(str);
							$("#area").html("");
							$("#area").append("<option>--请选择--</option>"); 
 			}
 			});
 	};
	
	function getAllArea(){
	debugger;
		var code_c = document.getElementById("city").value;
 			$.ajax({
 			type: "post",
 			url:"xzqh/area.do",
 			data:"code_c="+code_c,
 			dateType:"json",
 			success: function(json){
 				 var areaXx = JSON.parse(json);  
 				var str = "<option>--请选择--</option>";
							$("#area").html("");
							for ( var i = 0; i < areaXx.length; i++) {
							
								 str += "<option value='" + areaXx[i].code_a
										+ "'>" + areaXx[i].name
										+ "</option>"; 
							}
							 $("#area").append(str);
							
 			}
 			});
	
	
	}