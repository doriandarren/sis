function getAllClient(){
	   var parametros = {
           "get_all" : "-"
       };
	   $.ajax({
           url:   'https://my-api-new.appspot.com/_ah/api/apiclient/v1/get_all_client?get_all=all',
           type:  'get',
           beforeSend: function () {
        	   //document.getElementById("res_all_client").innerHTML = "Proccesing, waiting...";
           },
           success:  function (response) {  
        	   document.getElementById("form:cliente_id").innerHTML = ''; 
        	   for(i=0; i<response.items.length; i++){	
        		   var z = document.createElement("option");
	        	   z.setAttribute("value", response.items[i].key.id);
	        	   var t = document.createTextNode(response.items[i].name);
	        	   z.appendChild(t);
	        	   document.getElementById("form:cliente_id").appendChild(z);
        	   }
           },
           error : function(e) {
               alert('error'+e);
           }
   		});
   	}

function getAll(){	
	
	   var parametros = {
           "get_all" : "-"
       };
	   $.ajax({
           url:   'https://my-api-new.appspot.com/_ah/api/apiplace/v1/get_all_place?get_all=all',
           type:  'get',
           beforeSend: function () {
        	   document.getElementById("res_all").innerHTML = "Proccesing, waiting...";
           },
           success:  function (response) { 
        	   
        	   console.log(Object.values(response));
        	   
               res = "<table class='table' id='mytable'>";				
               	res+="<thead>";
            	res += "<tr>";
           		res += "<td>Name</td>";
           		res += "<td>Address</td>";
           		res += "<td>Description</td>";
           		res += "<td>Phone</td>";
           		res += "<td>Email</td>";
           		res += "<td>Zip</td>";
           		res += "<td>City</td>";
           		res += "<td>Actions</td>";
           		res += "</tr>";
           		res += "</thead>";
           		res += "<tbody>";
           		
               for(i=0; i<response.items.length; i++){
            	               	   
            	   res += "<tr>";
            	   res += "<td>"+response.items[i].name+"</td>";
            	   res += "<td>"+response.items[i].address+"</td>";
            	   res += "<td>"+response.items[i].description+"</td>";
            	   res += "<td>"+response.items[i].phone+"</td>";
            	   res += "<td>"+response.items[i].email+"</td>";
            	   res += "<td>"+response.items[i].codeZip+"</td>";
            	   res += "<td>"+response.items[i].city+"</td>";
            	   res += "<td><a type='button' href='javascript:;' onclick='find(\""+response.items[i].key.id+"\");return false;'>Update</a>";
            	   res += "<a type='button' href='javascript:;' onclick='del(\""+response.items[i].key.id+"\");return false;'>Delete</a></td>";
            	   res+="</tr>";	
               }
               
               
               res += "</tbody>";
               res += "</table>";
               
               
               $("#res_all").html(res);
               
           },
           error : function(e) {
        	   console.log(Object.values(e));
               alert('error'+e);
               $("#res_all").html("");
           }
   		});
   	}
   
     
   
	function save(){		
	    var parametros = {
	            "name" : document.getElementById("form:name").value,
	            "address" : document.getElementById("form:address").value,        
	            "description" : document.getElementById("form:description").value,
	            "phone" : document.getElementById("form:phone").value,
	            "email" : document.getElementById("form:email").value,
	            "codeZip" : document.getElementById("form:codeZip").value,
	            "city" : document.getElementById("form:city").value,
	            "clientId": document.getElementById("form:cliente_id").value
	    };
	    	    
	    $.ajax({
	            data:  parametros,
	            url:   'https://my-api-new.appspot.com/_ah/api/apiplace/v1/save_place',
	            type:  'post',
	            beforeSend: function () {
	            	document.getElementById("result").innerHTML = "Proccesing, waiting...";
	            },
	            success:  function (response) {	                	
	            	$("#result").addClass("alert alert-success").html(response.message);
	                document.getElementById("form:name").value="";
	                document.getElementById("form:address").value="";
	                document.getElementById("form:description").value="";
	                document.getElementById("form:phone").value="";
	                document.getElementById("form:email").value="";
	                document.getElementById("form:codeZip").value="";
	                document.getElementById("form:city").value="";	                
	                getAll();
	           },
	           error : function(e) {
	               alert('error'+e);
	           }
	    });
	}
	
	
	
	function find(id){
		$.ajax({
            //data:  client_id_id,
            url:   'https://my-api-new.appspot.com/_ah/api/apiplace/v1/get_place?place_id='+id,
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
	            url:   'https://my-api-new.appspot.com/_ah/api/apiplace/v1/delete_place?place_id='+id,
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
