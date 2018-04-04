function getAll(){
	   var parametros = {
           "get_all" : "-"
       };
	   $.ajax({
           url:   'https://my-api-new.appspot.com/_ah/api/apiclient/v1/get_all_client',
           type:  'get',
           beforeSend: function () {
        	   document.getElementById("res_all").innerHTML = "Proccesing, waiting...";
           },
           success:  function (response) {        	   
               res = "<table class='table' id='mytable'>";				
               	res+="<thead>";
            	res += "<tr>";
           		res += "<td>Name</td>";
           		res += "<td>Description</td>";
           		res += "<td>Create At</td>";
           		res += "<td>Actions</td>";
           		res += "</tr>";
           		res += "</thead>";
           		res += "<tbody>";
           		
               for(i=0; i<response.items.length; i++){
            	               	   
            	   res += "<tr>";
            	   res += "<td>"+response.items[i].name+"</td>";
            	   res += "<td>"+response.items[i].description+"</td>";
            	   res += "<td>"+response.items[i].createAt+"</td>";
            	   res += "<td><a type='button' href='javascript:;' onclick='find(\""+response.items[i].key.id+"\");return false;'>Update</a>";
            	   res += "<a type='button' href='javascript:;' onclick='del(\""+response.items[i].key.id+"\");return false;'>Delete</a></td>";
            	   res+="</tr>";	
               }
               
               
               res += "</tbody>";
               res += "</table>";
               
               
               $("#res_all").html(res);
               
           },
           error : function(e) {
               alert('error'+e);
               $("#res_all").html("");
           }
   		});
   	}
   
     
   
	function save(){		
	    var parametros = {
	            "name" : document.getElementById("form:name").value,
	            "description" : document.getElementById("form:description").value
	    };
	    	    
	    $.ajax({
	            data:  parametros,
	            url:   'https://my-api-new.appspot.com/_ah/api/apiclient/v1/save_client',
	            type:  'post',
	            beforeSend: function () {
	            	document.getElementById("result").innerHTML = "Proccesing, waiting...";
	            },
	            success:  function (response) {	                	
	            	$("#result").addClass("alert alert-success").html(response.message);
	                document.getElementById("form:name").value="";
	                document.getElementById("form:description").value="";
	                getAll();
	           }
	    });
	}
	
	
	
	function find(id){
		$.ajax({
            //data:  client_id_id,
            url:   'https://my-api-new.appspot.com/_ah/api/apiclient/v1/get_client?client_id='+id,
            type:  'get',
            beforeSend: function () {
            	document.getElementById("result").innerHTML = "Proccesing, waiting...";
            },
            success:  function (response) {             	
            	document.getElementById("result").className = '';
            	document.getElementById("result").innerHTML = "";
            	document.getElementById("form:id").value=response.key.id;
                document.getElementById("form:name").value=response.name;
                document.getElementById("form:description").value=response.description;
           },
           error : function(e) {
               alert('error'+e);
           }
    	});
	}
	
	
	function update(){
		
		var data = {
		    name : document.getElementById("form:name").value,
		    description : document.getElementById("form:description").value,
		    id : document.getElementById("form:id").value
		};
				
		$.ajax({
            data:  data,
            url:   'https://my-api-new.appspot.com/_ah/api/apiclient/v1/update_client',
            type:  'POST',
            beforeSend: function () {
            	document.getElementById("result").innerHTML = "Proccesing, waiting...";
            },
            success:  function (response) {	
                $("#result").addClass("alert alert-success").html(response.message);
                
                document.getElementById("form:id").value="";
                document.getElementById("form:name").value="";
                document.getElementById("form:description").value="";
                getAll();
           },
           error : function(e) {
               alert('error'+e);
               console.log(Object.values(e));
           }
    	});
	}
	
	
	function del(id){		
		var conf = confirm('Desea Eliminar el registro?');
		if(conf==true){
			$.ajax({
	            url:   'https://my-api-new.appspot.com/_ah/api/apiclient/v1/delete_client?client_id='+id,
	            type:  'get',
	            beforeSend: function () {
	            	document.getElementById("result").innerHTML = "Proccesing, waiting...";
	            },
	            success:  function (response) { 
	            	$("#result").addClass("alert alert-success").html(response.message);
	            	getAll();
	           },
	           error : function(e) {
	               alert('error'+e);
	           }
	    	});	
		}
	}
