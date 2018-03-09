package com.app.sis.client;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Test;

import com.app.api.datastore.EMF;
import com.app.api.model.Client;

public class TestFindClient extends TestBaseClient {
	
	@Test
	public void testGetFind() {
		
		Client client = getMockClient();
		
		EntityManager em = EMF.get().createEntityManager();
		em.persist(client);
		em.close();
		
		
		EntityManager emF = EMF.get().createEntityManager();
		Client clientFind = emF.find(Client.class, client.getKey());
		emF.close();
		
		System.out.println(client.getKey().getId());
		
		long id = client.getKey().getId();
		
		
		EntityManager emFi = EMF.get().createEntityManager();
		Client clientFind2 = emFi.find(Client.class, id);
		emFi.close();
		
		
		
		Assert.assertNotNull(clientFind);
		
		Assert.assertNotNull(clientFind2);
	}
	

}
