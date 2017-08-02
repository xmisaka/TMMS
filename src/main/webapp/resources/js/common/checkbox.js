//全选/取消全选
$(function(){
	$("#checkall").click(function(){
		var isckecked=$(this).prop("checked");
        $("input[name='menuId']").each(function() {  
            this.checked = isckecked;  
        });  
	})
})
//父菜单，子菜单选择判断
$(function(){
	$("input[name='menuId']").click(function(){
		var isckecked=$(this).prop("checked");
		var node=$(this).attr("node");
		if(node.length==1){
			 $("input[name='menuId']").each(function() {  
				    var node1=$(this).attr("node");
				    if(node1.length>1){
				    	if(node1.substring(0,1)==node){
				    		 this.checked = isckecked; 
				    	}
				    }
		        });
		}
		if(node.length==2){
		     var bother=0;
		     $("input[name='menuId']").each(function() {
		    	 var node1=$(this).attr("node");
				 var isckecked1=$(this).prop("checked");
		    	 if(node1.length==2){
				    	if(node1.substring(0,1)==node.substring(0,1)){
				    		if(isckecked1){
				    			bother=1;
				    		}
				    	}
				  }
		     });
			 $("input[name='menuId']").each(function() {  
				    var node1=$(this).attr("node");
				    var isckecked1=$(this).prop("checked");
				    if(node1.length>2){
				    	if(node1.substring(0,2)==node){
				    		 this.checked = isckecked; 
				    	}
				    }
				    if(node1.length==1){
				    	if(node.substring(0,1)==node1){
				    		 if(isckecked){
				    			 this.checked = isckecked;  
				    		 }else{
				    			 if(bother==0){
				    				 this.checked = isckecked;
				    			 }
				    		 }
				    	}
				    }
		        });
		}
		if(node.length==3){
		     var bother=0;
		     $("input[name='menuId']").each(function() {
		    	 var node1=$(this).attr("node");
				 var isckecked1=$(this).prop("checked");
		    	 if(node1.length==3){
				    	if(node1.substring(0,2)==node.substring(0,2)){
				    		if(isckecked1){
				    			bother=1;
				    		}
				    	}
				  }
		     });
			 $("input[name='menuId']").each(function() {  
				    var node1=$(this).attr("node");
				    var isckecked1=$(this).prop("checked");
				    if(node1.length>3){
				    	if(node1.substring(0,3)==node){
				    		 this.checked = isckecked; 
				    	}
				    }
				    if(node1.length==2){
				    	if(node.substring(0,2)==node1){
				    		 if(isckecked){
				    			 this.checked = isckecked;  
				    		 }else{
				    			 if(bother==0){
				    				 this.checked = isckecked;
				    			 }
				    		 }
				    	}
				    }
				    if(node1.length==1){
				    	if(node.substring(0,1)==node1){
				    		 if(isckecked){
				    			 this.checked = isckecked;  
				    		 }else{
				    			 if(bother==0){
				    				 this.checked = isckecked;
				    			 }
				    		 }
				    	}
				    }
		        });
		}
	})
})
