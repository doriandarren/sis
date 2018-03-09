package com.app.sis.incidense;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Test;

import com.app.api.datastore.DAOIncidense;
import com.app.api.datastore.EMF;
import com.app.api.model.Client;
import com.app.api.model.Incidense;
import com.app.api.model.Place;

public class TestDeleteIncidense extends TestBaseIncidense {

	@Test
	public void testDelete() {
		
		// Crea Client
		Client client = getMockClient();
		EntityManager emC = EMF.get().createEntityManager();
		emC.persist(client);
		emC.close();

		// Crea Place
		Place place = getMockPlace();
		EntityManager emP = EMF.get().createEntityManager();
		emP.persist(place);
		place.setClient(client);
		client.getListPlace().add(place);
		emP.close();

		// Crea la Incidense
		Incidense incidense = getMockIncidcense();
		EntityManager emI = EMF.get().createEntityManager();		
		emI.persist(incidense);
		incidense.setPlace(place);
		place.getListIncidense().add(incidense);		
		emI.close();
				
		//Service DAO		
		DAOIncidense service = new DAOIncidense();
		service.delete(incidense.getKey());
		
		//Se buscan Todos
		EntityManager emF = EMF.get().createEntityManager();
		Incidense incidenseFind = emF.find(Incidense.class, incidense.getKey());		
		Client clientFind = emF.find(Client.class, client.getKey());
		Place placeFind = emF.find(Place.class, place.getKey());
		emF.close();
				
		//El client queda
		Assert.assertNotNull(clientFind);
		// El place queda
		Assert.assertNotNull(placeFind);
		// El place se elimina
		Assert.assertNull(incidenseFind);
	}
}
