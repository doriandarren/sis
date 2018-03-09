package com.app.sis.place;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Test;

import com.app.api.datastore.DAOPlace;
import com.app.api.datastore.EMF;
import com.app.api.model.Client;
import com.app.api.model.Place;



public class TestUpdatePlace extends TestBasePlace {

	@Test
	public void testUpdate() {
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
			
		EntityManager emU = EMF.get().createEntityManager();
		Place placeUpdate = emU.find(Place.class, place.getKey());
		emU.close();
				
		placeUpdate.setName(NAME_PLACE_UPDATE);
		placeUpdate.setAddress(ADDRESS_PLACE_UPDATE);
		placeUpdate.setDescription(DESCRIPTION_PLACE_UPDATE);
		placeUpdate.setPhone(PHONE_PLACE_UPDATE);
		placeUpdate.setEmail(EMAIL_PLACE_UPDATE);
		place.setCodeZip(CODE_ZIP_PLACE_UPDATE);
		place.setCity(CITY_PLACE_UPDATE);
		
		
		DAOPlace service = new DAOPlace();
		service.update(placeUpdate);
		
		EntityManager emF = EMF.get().createEntityManager();
		Place placeFind = emF.find(Place.class, placeUpdate.getKey());
		emF.close();
		
		Assert.assertEquals(NAME_PLACE_UPDATE, placeFind.getName());
		Assert.assertEquals(ADDRESS_PLACE_UPDATE, placeFind.getAddress());
		Assert.assertEquals(DESCRIPTION_PLACE_UPDATE, placeFind.getDescription());
		Assert.assertEquals(PHONE_PLACE_UPDATE, placeFind.getPhone());
		Assert.assertEquals(EMAIL_PLACE_UPDATE, placeFind.getEmail());
		Assert.assertEquals(CODE_ZIP_PLACE_UPDATE, placeFind.getCodeZip());
		Assert.assertEquals(CITY_PLACE_UPDATE, placeFind.getCity());
	}
	
}
