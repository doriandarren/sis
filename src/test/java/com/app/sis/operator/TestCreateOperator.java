package com.app.sis.operator;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Test;

import com.app.api.datastore.DAOOperator;
import com.app.api.datastore.EMF;
import com.app.api.model.Client;
import com.app.api.model.Incidense;
import com.app.api.model.Operator;
import com.app.api.model.Place;

public class TestCreateOperator extends TestBaseOperator {

	@Test
	public void testCreateOperator() {
			
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
		
				
		Operator operator = getMockOperator();
		
		DAOOperator service = new DAOOperator();
		service.create(incidense.getKey(), operator);
		
		
		EntityManager emF = EMF.get().createEntityManager();
		Operator operatorFind = emF.find(Operator.class, operator.getKey());
		emF.close();
		
		Assert.assertNotNull(operatorFind);
		Assert.assertEquals(NAME_OPERATOR, operatorFind.getName());
		Assert.assertEquals(EMAIL_OPERATOR, operatorFind.getEmail());
		Assert.assertEquals(PHONE_OPERATOR, operatorFind.getPhone());
		Assert.assertEquals(OBSERVATION_OPERATOR, operatorFind.getObservation());
		
	}
	
}
