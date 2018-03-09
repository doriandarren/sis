package com.app.sis.client;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Test;

import com.app.api.datastore.DAOClient;
import com.app.api.datastore.EMF;
import com.app.api.model.Client;

public class TestUpdateClient extends TestBaseClient{

	
	@Test
	public void testUpdate() {
		
		Client client = getMockClient();
		
		EntityManager em = EMF.get().createEntityManager();
		em.persist(client);
		em.close();
		
		EntityManager emU = EMF.get().createEntityManager();
		Client clientUpdate = emU.find(Client.class, client.getKey());
		emU.close();
		
		clientUpdate.setName(NAME_UPDATE);
		clientUpdate.setDescription(DESCRIPTION_UPDATE);
		clientUpdate.setCreateAt(CREATE_AT_UPDATE);
		
		DAOClient service = new DAOClient();
		service.update(clientUpdate);
		
		EntityManager emF = EMF.get().createEntityManager();
		Client clientFind = emF.find(Client.class, client.getKey());
		emF.close();
				
		Assert.assertEquals(NAME_UPDATE, clientFind.getName());
		Assert.assertEquals(DESCRIPTION_UPDATE, clientFind.getDescription());
		Assert.assertEquals(CREATE_AT_UPDATE, clientFind.getCreateAt());
		
		
		
	}
	
}
