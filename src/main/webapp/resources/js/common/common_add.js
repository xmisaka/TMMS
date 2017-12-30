//学院，专业，班级下拉框某个option被选中时触发事件
$("#collegeId").change(function(){
	var collegeId=$("#collegeId").val();
	var params={collegeId:collegeId}
	var url=basePath+"/specialty/selectbycollegeid";
	$.post(url,params,function(responseText){
		 var data=eval("("+responseText+")"); 
		 var content="";
		 if(data.length==0){
			 $("#specialtyId").html(content);
			 $("#classId").html(content);
		 }else{
			 for(var i=0;i<data.length;i++){
				 if(i==0){
					 findClass(data[i]["specialtyId"]);
				 }
				 content+="<option value=\""+data[i]["specialtyId"]+"\">"+data[i]["specialtyName"]+"</option>"
			 }
			 $("#specialtyId").html(content); 
		 }
	})
})
$("#specialtyId").change(function(){
	var specialtyId=$("#specialtyId").val();
	var params={specialtyId:specialtyId}
	var url=basePath+"/class/selectbyspecialtyid";
	$.post(url,params,function(responseText){
		 var data=eval("("+responseText+")"); 
		 var content="";
		 for(var i=0;i<data.length;i++){
			 content+="<option value=\""+data[i]["classId"]+"\">"+data[i]["className"]+"</option>"
		 }
		 $("#classId").html(content);
	})
})
//初始化学院，专业，班级信息
$(document).ready(function(){
	var url=basePath+"/college/selectall";
	$.post(url,function(responseText){
		 var data=eval("("+responseText+")"); 
		 var content="";
		 if(data.length==0){
			 $("#collegeId").html(content);
			 $("#specialtyId").html(content);
			 $("#classId").html(content);
		 }else{
			 for(var i=0;i<data.length;i++){
				 if(i==0){
					 findSpecialty(data[i]["collegeId"]);
				 }
				 content+="<option value=\""+data[i]["collegeId"]+"\">"+data[i]["collegeName"]+"</option>"
			 }
			 $("#collegeId").html(content); 
		 }
    })
})
function findSpecialty(collegeId){
	var params={collegeId:collegeId}
	var url=basePath+"/specialty/selectbycollegeid";
	$.post(url,params,function(responseText){
		 var data=eval("("+responseText+")"); 
		 var content="";
		 if(data.length==0){
			 $("#specialtyId").html(content);
			 $("#classId").html(content);
		 }else{
			 for(var i=0;i<data.length;i++){
				 if(i==0){
					 findClass(data[i]["specialtyId"]);
				 }
				 content+="<option value=\""+data[i]["specialtyId"]+"\">"+data[i]["specialtyName"]+"</option>"
			 }
			 $("#specialtyId").html(content); 
		 }
    })
}
function findClass(specialtyId){
	var params={specialtyId:specialtyId}
	var url=basePath+"/class/selectbyspecialtyid";
	$.post(url,params,function(responseText){
		 var data=eval("("+responseText+")"); 
		 var content="";
		 for(var i=0;i<data.length;i++){
			 content+="<option value=\""+data[i]["classId"]+"\">"+data[i]["className"]+"</option>"
		 }
		 $("#classId").html(content);
	})
}
