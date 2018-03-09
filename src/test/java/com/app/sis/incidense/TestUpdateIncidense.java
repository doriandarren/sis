package com.app.sis.incidense;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Test;

import com.app.api.datastore.DAOIncidense;
import com.app.api.datastore.EMF;
import com.app.api.model.Client;
import com.app.api.model.Incidense;
import com.app.api.model.Place;

public class TestUpdateIncidense extends TestBaseIncidense{

	@Test
	public void testUpdate() {
				
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
		
		EntityManager emU = EMF.get().createEntityManager();
		Incidense incidenseUpdate = emU.find(Incidense.class, incidense.getKey());
		emU.close();
		
		incidenseUpdate.setDescription(DESCRIPTION_INCIDENSE_UPDATE);
		incidenseUpdate.setNumberAlbaran(NUMBER_ALBARAN_INCIDENSE_UPDATE);
		incidenseUpdate.setCreateAt(CREATE_AT_INCIDENSE_UPDATE);
		incidenseUpdate.setAtentionAt(ATENTION_AT_INCIDENSE_UPDATE);
		incidenseUpdate.setCloseAt(CLOSE_AT_INCIDENSE_UPDATE);
		incidenseUpdate.setStatus(STATUS_INCIDENSE_UPDATE);
				
		// Service DAO
		DAOIncidense service = new DAOIncidense();
		service.update(incidenseUpdate);
		
		
		EntityManager emF = EMF.get().createEntityManager();
		Incidense incidenseFind = emF.find(Incidense.class, incidense.getKey());
		emF.close();
				
		Assert.assertEquals(DESCRIPTION_INCIDENSE_UPDATE,incidenseFind.getDescription());
		Assert.assertEquals(NUMBER_ALBARAN_INCIDENSE_UPDATE, incidenseFind.getNumberAlbaran());
		Assert.assertEquals(CREATE_AT_INCIDENSE_UPDATE,incidenseFind.getCreateAt());
		Assert.assertEquals(ATENTION_AT_INCIDENSE_UPDATE, incidenseFind.getAtentionAt());
		Assert.assertEquals(CLOSE_AT_INCIDENSE_UPDATE, incidenseFind.getCloseAt());
		Assert.assertEquals(STATUS_INCIDENSE_UPDATE, incidenseFind.getStatus());
				
	}
	
}
