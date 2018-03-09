package com.app.sis.incidense;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Test;

import com.app.api.datastore.DAOIncidense;
import com.app.api.datastore.EMF;
import com.app.api.model.Client;
import com.app.api.model.Incidense;
import com.app.api.model.Place;

public class TestCreateIncidense extends TestBaseIncidense {

	@Test
	public void testCreate() {
		
		//Crea Client
		Client client = getMockClient();
		EntityManager emC = EMF.get().createEntityManager();
		emC.persist(client);
		emC.close();
		
		//Crea Place
		Place place = getMockPlace();
		EntityManager emP = EMF.get().createEntityManager();				
		emP.persist(place);
		place.setClient(client);
		client.getListPlace().add(place);
		emP.close();
		
		
		//Crea la Incidense
		Incidense incidense = getMockIncidcense();
				
		DAOIncidense service = new DAOIncidense();
		service.create(place.getKey(), incidense);
						
		
		EntityManager emF = EMF.get().createEntityManager();
		Incidense incidenseFind = emF.find(Incidense.class, incidense.getKey());		
		Client clientFind = emF.find(Client.class, client.getKey());
		Place placeFind = emF.find(Place.class, place.getKey());
		emF.close();
				
		
		Assert.assertNotNull(clientFind);
		Assert.assertNotNull(placeFind);
		Assert.assertNotNull(incidenseFind);		
		Assert.assertEquals(DESCRIPTION_INCIDENSE, incidenseFind.getDescription());
		Assert.assertEquals(NUMBER_ALBARAN_INCIDENSE, incidenseFind.getNumberAlbaran());
		Assert.assertEquals(CREATE_AT_INCIDENSE, incidenseFind.getCreateAt());
		Assert.assertEquals(ATENTION_AT_INCIDENSE,incidenseFind.getAtentionAt());
		Assert.assertEquals(CLOSE_AT_INCIDENSE,incidenseFind.getCloseAt());
		Assert.assertEquals(STATUS_INCIDENSE,incidenseFind.getStatus());
	}
	
}
