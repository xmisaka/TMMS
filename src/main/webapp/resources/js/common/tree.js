//树形菜单
$(function(){
  　　$('.tree li:has(ul)').addClass('parent_li').find(' > span').attr('title', 'Collapse this branch');
　　$('.tree li.parent_li > span').on('click', function (e) {
   　　 var children = $(this).parent('li.parent_li').find(' > ul > li');
    　　if (children.is(":visible")) {
        　　children.hide('fast');
        　　$(this).attr('title', 'Expand this branch').find(' > i').addClass('icon-plus-sign').removeClass('icon-minus-sign');
    　　} else {
        　　children.show('fast');
        　　$(this).attr('title', 'Collapse this branch').find(' > i').addClass('icon-minus-sign').removeClass('icon-plus-sign');
    　　}
    　　e.stopPropagation();
　　});
});

$(".menuc").click(function(){
	var node=$(this).attr("node");
	var params={parentId:node}
	var url=basePath+"menuitem/menuitemnode";
	$.post(url,params,function(responseText){
		var data=eval("("+responseText+")"); 
		var content="";
		for(var i=0;i<data.length;i++){
			var id=data[i].id;   
			var menuName=data[i].menuName;	
			var parentId=data[i].parentId;
			var uri=data[i].uri;
			var icon=data[i].icon;
			
			content+="<tr>";
			content+="<td class=\"center\"><input type=\"checkbox\" name=\"id\" value=\""+id+"\" /></td>";
			content+="<td>"+(i+1)+"</td>";
			content+="<td>"+menuName+"</td>";
			content+="<td>"+parentId+"</td>";
			content+="<td>"+uri+"</td>";
			content+="<td>"+icon+"</td>";
			content+="<td><div class=\"hidden-sm hidden-xs action-buttons\">";
			content+="<a class=\"blue\" href=\"#\"> <i class=\"ace-icon fa fa-search-plus bigger-130\"></i></a>";
			content+="<a class=\"green\" href=\""+id+"/menuitemedit\">修改 <i class=\"icon-edit\"></i></a>";
			content+="<a class=\"red\" href=\""+id+"/menuitemdel\">删除 <i class=\"icon-trash\"></i></a>";
			content+="</div></td>";
		}
		$(".content").html(content);
	});
})