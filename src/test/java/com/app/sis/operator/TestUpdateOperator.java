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

public class TestUpdateOperator extends TestBaseOperator {

	
	@Test
	public void testUpdateOperator() {
		
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

		// Crea el Operator
		Operator operator = getMockOperator();
		EntityManager emO = EMF.get().createEntityManager();
		emO.persist(operator);
		operator.setIncidense(incidense);
		incidense.getListOperator().add(operator);
		emO.close();

		//Se busca Operator
		EntityManager emU = EMF.get().createEntityManager();
		Operator operatorUpdate = emU.find(Operator.class, operator.getKey());
		emU.close();
				
		operatorUpdate.setName(NAME_OPERATOR_UPDATE);
		operatorUpdate.setEmail(EMAIL_OPERATOR_UPDATE);
		operatorUpdate.setPhone(PHONE_OPERATOR_UPDATE);
		operatorUpdate.setObservation(OBSERVATION_OPERATOR_UPDATE);
		
		DAOOperator service = new DAOOperator();
		service.update(operatorUpdate);
				
		//Se busca Operator
		EntityManager emF = EMF.get().createEntityManager();
		Operator operatorFind = emF.find(Operator.class, operator.getKey());
		emF.close();
				
		Assert.assertEquals(NAME_OPERATOR_UPDATE, operatorFind.getName());
		Assert.assertEquals(EMAIL_OPERATOR_UPDATE, operatorFind.getEmail());
		Assert.assertEquals(PHONE_OPERATOR_UPDATE, operatorFind.getPhone());
		Assert.assertEquals(OBSERVATION_OPERATOR_UPDATE, operatorFind.getObservation());
		
	}
		
	
}
