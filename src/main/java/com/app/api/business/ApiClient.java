package com.app.api.business;


import java.util.Date;
import java.util.List;

import com.app.api.datastore.DAOClient;
import com.app.api.model.Client;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiIssuer;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;

//[START echo_api_annotation]
@Api(
name = "apiclient",
version = "v1",
namespace =
@ApiNamespace(
 ownerDomain = "apiclient.business.api.app.com",
 ownerName = "apiclient.business.api.app.com",
 packagePath = ""
),
//[START_EXCLUDE]
issuers = {
@ApiIssuer(
 name = "firebase",
 issuer = "https://securetoken.google.com/my-api-new",
 jwksUri = "https://www.googleapis.com/robot/v1/metadata/x509/securetoken@system.gserviceaccount.com")
}
//[END_EXCLUDE]
)
//[END echo_api_annotation]
public class ApiClient {
	
	private DAOClient service;
	
	@ApiMethod(name="save_client", path="save_client")
	public Message saveClient(Client client) {		
		Message message = new Message();			
		try {
			message.setMessage("Save...");
			client.setCreateAt(new Date());
			service = new DAOClient();			
			service.create(client);
		} catch (Exception e) {
			e.printStackTrace();
			message.setMessage("Fail...");			
		}						
		return message;
	}
	
	
	
	@ApiMethod(name="update_client", path="update_client", httpMethod = "POST")
	public Message updateClient(Client client) {		
		Message message = new Message();
		
		try {		
			long key = Long.parseLong(client.getId());
			service = new DAOClient();
			Client clientUpdate = service.find(Client.class, key);
			clientUpdate.setName(client.getName());
			clientUpdate.setDescription(client.getDescription());
			service.update(clientUpdate);			
			message.setMessage("Update...");			
		}catch(Exception e){
			e.printStackTrace();
			message.setMessage("Fail..." + e.getMessage());
		}
		return message;
	}
	
	
	@ApiMethod(name="delete_client", path="delete_client", httpMethod = HttpMethod.GET)
	public Message deleteClient(@Named("client_id") String clientId) {
		Message message = new Message();
		long key = Long.parseLong(clientId);		
		try {			
			service = new DAOClient();
			Client client = service.find(Client.class, key);
			service.delete(client.getKey());
			message.setMessage("Delete...");
		} catch (Exception e) {			
			e.printStackTrace();
			message.setMessage("Fail...");
		}						
		return message;
	}
	
	
	
	
	@ApiMethod(name="get_all_client", path="get_all_client", httpMethod = HttpMethod.GET)
	public List<Client> getAllClient(@Named("get_all") String getAll) {
		List<Client> list = null;
		try {
			service = new DAOClient();
			list = service.findAll(Client.class);			
		} catch (Exception e) {
			e.printStackTrace();
		}						
		return list;	
	}
		
		
	@ApiMethod(name="get_client", path="get_client", httpMethod = HttpMethod.GET)
	public Client getClient(@Named("client_id") String clientId) {	
		Client client = null;
		
		long id = Long.parseLong(clientId);
		
		try {
			service = new DAOClient();
			client = service.find(Client.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return client;
	}
			
}
