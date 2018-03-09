package com.app.sis.operator;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Test;

import com.app.api.datastore.DAOOperator;
import com.app.api.datastore.EMF;
import com.app.api.model.Operator;

public class TestFindOperator extends TestBaseOperator {

	@Test
	public void testGetAllOperator() {
		Operator operator1 = getMockOperator("Dariana","658969696","dariana@app.es","No tiene niguna observacion");
		Operator operator2 = getMockOperator("Dilan","4444444","dilan@app.es","Sin niguna observacion");
		Operator operator3 = getMockOperator("Luisa","88888888","luisa@app.es","Alguna observacion");
		Operator operator4 = getMockOperator("Aron","999999999","aron@app.es","Observacion de criterio");
		
				
		EntityManager em1 = EMF.get().createEntityManager();
		em1.persist(operator1);
        em1.close();
        
        EntityManager em2 = EMF.get().createEntityManager();
		em2.persist(operator2);
        em2.close();
        
        EntityManager em3 = EMF.get().createEntityManager();
		em3.persist(operator3);
        em3.close();
        
        
        EntityManager em4 = EMF.get().createEntityManager();
		em4.persist(operator4);
        em4.close();
        
        
        
				
		DAOOperator service = new DAOOperator();
		List<Operator> list = service.findAll(Operator.class);
		
		Assert.assertEquals(4, list.size());
		
		//Assert.assertEquals("Dariana", list.get(0).getName());
						
	}
	
}
