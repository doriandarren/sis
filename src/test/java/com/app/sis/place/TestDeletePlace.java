package com.app.sis.place;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Test;

import com.app.api.datastore.DAOPlace;
import com.app.api.datastore.EMF;
import com.app.api.model.Client;
import com.app.api.model.Place;

public class TestDeletePlace extends TestBasePlace {

	@Test
	public void testDelete() {
	
		Client client = getMockClient();
		EntityManager em = EMF.get().createEntityManager();
		em.persist(client);
		em.close();
				
		Place place = getMockPlace();
		
		EntityManager emP = EMF.get().createEntityManager();
		emP.persist(place);
		place.setClient(client);
		client.getListPlace().add(place);
		emP.close();
			
		
		DAOPlace service = new DAOPlace();
		service.delete(place.getKey());
				
		//El Place se elimina
		EntityManager emF = EMF.get().createEntityManager();
		Place placeFind = emF.find(Place.class, place.getKey());
		Client clientFind = emF.find(Client.class, client.getKey());
		emF.close();
		
		//El client queda
		Assert.assertNotNull(clientFind);
		//El place se elimina
		Assert.assertNull(placeFind);				
		
		
	}	
}
