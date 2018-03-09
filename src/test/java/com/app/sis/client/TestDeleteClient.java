package com.app.sis.client;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Test;

import com.app.api.datastore.DAOClient;
import com.app.api.datastore.EMF;
import com.app.api.model.Client;

public class TestDeleteClient extends TestBaseClient {

	
	@Test
	public void testDelete() {
		
		Client client = getMockClient();
		
		EntityManager em = EMF.get().createEntityManager();
		em.persist(client);
		em.close();
		
		DAOClient service = new DAOClient();
		service.delete(client.getKey());
		
		EntityManager emF = EMF.get().createEntityManager();
		Client clientFind = emF.find(Client.class, client.getKey());
		emF.close();
		
		Assert.assertNull(clientFind);
				
	}
	
}
