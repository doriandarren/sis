package com.app.api.business;

import java.util.List;

import com.app.api.datastore.DAOOperator;
import com.app.api.model.Operator;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiIssuer;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;



//[START echo_api_annotation]
@Api(
name = "apioperator",
version = "v1",
namespace =
 @ApiNamespace(
   ownerDomain = "apioperator.business.api.app.com",
   ownerName = "apioperator.business.api.app.com",
   packagePath = ""
 ),
// [START_EXCLUDE]
issuers = {
 @ApiIssuer(
   name = "firebase",
   issuer = "https://securetoken.google.com/my-api-new",
   jwksUri = "https://www.googleapis.com/robot/v1/metadata/x509/securetoken@system.gserviceaccount.com")
}
// [END_EXCLUDE]
)
//[END echo_api_annotation]
public class ApiOperator {
	
	private DAOOperator service;
	
	@ApiMethod(name="save_operator", path="save_operator")
	public Message saveOperator(Operator operator) {		
		Message message = new Message();			
		try {
			message.setMessage("Save...");
			service = new DAOOperator();
			//service.create(,operator);
		} catch (Exception e) {
			message.setMessage("Fail...");
			e.printStackTrace();
		}						
		return message;
	}
	
	@ApiMethod(name="update_operator", path="update_operator")
	public Message updateOperator(Operator operator) {		
		Message message = new Message();			
		try {
			message.setMessage("Update...");
			service = new DAOOperator();
			service.update(operator);
		} catch (Exception e) {
			message.setMessage("Fail...");
			e.printStackTrace();
		}						
		return message;
	}
	
	@ApiMethod(name="delete_operator", path="delete_operator", httpMethod = HttpMethod.GET)
	public Message deleteOperator(@Named("operator_id") String operatorId) {		
		Message message = new Message();			
		try {
			message.setMessage("Delete...");
			service = new DAOOperator();
			//service.delete(operatorId);
		} catch (Exception e) {
			message.setMessage("Fail...");
			e.printStackTrace();
		}						
		return message;
	}
	
	
	@ApiMethod(name="get_all_operator", path="get_all_operator", httpMethod = HttpMethod.GET)
	public List<Operator> getAllOperator(@Named("get_all") String getAll) {		
		
		//Message message = new Message();			
		
		List<Operator> list = null;
		try {
			
			service = new DAOOperator();
			list = service.findAll(Operator.class);
						
			/*StringBuilder sb = new StringBuilder();
			for(int i=0; i<listOperator.size();i++) {
				sb.append(listOperator.get(i).getName());
				sb.append(listOperator.get(i).getEmail());
				sb.append(listOperator.get(i).getPhone());
				sb.append(listOperator.get(i).getObservation());
				sb.append("-");
			}
			
			message.setMessage("Get All..."+sb.toString());*/
			
		} catch (Exception e) {
			e.printStackTrace();
		}						
		return list;
	}
	
	
	@ApiMethod(name="get_operator", path="get_operator", httpMethod = HttpMethod.GET)
	public Operator getOperator(@Named("operator_id") String operator_id) {	
		Operator operator = null;
		try {			
			service = new DAOOperator();
			operator = service.find(Operator.class, operator_id);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return operator;
	}
	
}
