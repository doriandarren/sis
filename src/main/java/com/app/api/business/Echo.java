package com.app.api.business;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.app.api.datastore.EMF;
import com.app.api.model.Message;
import com.app.api.model.Operator;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiIssuer;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.config.Nullable;




//[START echo_api_annotation]
@Api(
 name = "echo",
 version = "v1",
 namespace =
   @ApiNamespace(
     ownerDomain = "echo.business.api.app.com",
     ownerName = "echo.business.api.app.com",
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

public class Echo {
	
	//Para entrar: http://localhost:8080/_ah/api/echo/v1/echoMessage?message=ola&n=5
	@ApiMethod(name="echoMessage", path="echoMessage", httpMethod = HttpMethod.GET)
	public Message echoMessage(Message message, @Named("n") @Nullable Integer n) {					
		//return 	message;	
		return doEcho(message,n);
	}
	
	
	
	@ApiMethod(name="saveMessage", path="saveMessage", httpMethod = HttpMethod.GET)
	public Message saveMessage(Message message) {					
				
		EntityManager em = EMF.get().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(message);
            em.getTransaction().commit();
        } catch (Exception e) {
            
        } finally {
            em.close();
        }		
		return message;
	}
	
	
	
	private Message doEcho(Message message, Integer n) {	
		return message;
	}
	
	
	
	@ApiMethod(name="save_operator", path="save_operator")
	public Message saveOperator(Operator operator) {					
		
		Message message = new Message();
		message.setMessage("Save...");
		
		EntityManager em = EMF.get().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(operator);
            em.getTransaction().commit();
        } catch (Exception e) {
            
        } finally {
            em.close();
        }		
		return message;
	}
	
	
	
	
	
	
	
	
	
	
}
