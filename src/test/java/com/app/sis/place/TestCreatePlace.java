package com.app.sis.place;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Test;

import com.app.api.datastore.DAOPlace;
import com.app.api.datastore.EMF;
import com.app.api.model.Client;
import com.app.api.model.Place;

public class TestCreatePlace extends TestBasePlace{

	
	@Test
	public void testCreate() {
		
		Client client = getMockClient();
		EntityManager em = EMF.get().createEntityManager();
		em.persist(client);
		em.close();
				
		Place place = getMockPlace();
				
		DAOPlace service = new DAOPlace();
		service.create(client.getKey(), place);
				
		EntityManager emF = EMF.get().createEntityManager();
		Client clientFind = emF.find(Client.class, client.getKey());
		emF.close();
						
		Assert.assertEquals(1, clientFind.getListPlace().size());		
		Assert.assertEquals(place.getName(),clientFind.getListPlace().get(0).getName());
		Assert.assertEquals(place.getDescription(),clientFind.getListPlace().get(0).getDescription());
		Assert.assertEquals(place.getAddress(), clientFind.getListPlace().get(0).getAddress());
		Assert.assertEquals(place.getCodeZip(), clientFind.getListPlace().get(0).getCodeZip());
		Assert.assertEquals(place.getCity(), clientFind.getListPlace().get(0).getCity());
	}
	
}
