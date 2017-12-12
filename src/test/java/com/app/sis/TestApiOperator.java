package com.app.sis;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.app.api.datastore.AppService;
import com.app.api.datastore.InfAppService;
import com.app.api.model.Operator;


import static com.google.appengine.api.datastore.FetchOptions.Builder.withLimit;
import static org.junit.Assert.assertEquals;

import javax.inject.Inject;
import javax.inject.Named;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;


public class TestApiOperator {
	
	//@Inject
	//private InfAppService service;
	
	private AppService service;
	
	
	/*private static final LocalServiceTestHelper helper = 
			new LocalServiceTestHelper( new LocalDatastoreServiceTestConfig());
	
	@BeforeClass
	public static void initialSetup() {
	    helper.setUp();
	}

	@AfterClass
	public static void finalTearDown() {
	    helper.tearDown();
	}
	*/
	
	 private final LocalServiceTestHelper helper =
		      new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());
	
	 
	 
	 @Before
	public void setUp() {
		helper.setUp();
		
		
	}

	@After
	public void tearDown() {
		helper.tearDown();
	}
		
	
	
	@Test
	public void testAddOperator() {
		
		Operator operator = mockOperator("Dariana Damiled","658969696","dari@dari.es","No tiene niguna observacion");
		service = new AppService();
		service.addOperator(operator);
		
		Operator operatorFind = service.find(Operator.class, operator.getId());
		
		Assert.assertEquals(operator.getName(), operatorFind.getName());
	}

	
	@Test
	public void testUpdateOperator() {
		
		Operator operator = mockOperator("Dariana Damiled","658969696","dari@dari.es","No tiene niguna observacion");
		service = new AppService();
		service.addOperator(operator);
		
		Operator operatorUpdate = service.find(Operator.class, operator.getId());
		
		operatorUpdate.setName("Milena");
		operatorUpdate.setEmail("miel@mile.es");
		operatorUpdate.setPhone("8888888");
		operatorUpdate.setObservation("Hasta los momentos bien!!");
		
		service.updateOperator(operatorUpdate);
		
		Operator operatorResul = service.find(Operator.class, operator.getId());
				
		Assert.assertEquals("Milena", operatorResul.getName());
		Assert.assertEquals("miel@mile.es", operatorResul.getEmail());
		Assert.assertEquals("8888888", operatorResul.getPhone());
		Assert.assertEquals("Hasta los momentos bien!!", operatorResul.getObservation());
		
	}
		
	
	
	


	
	//MOCK
	private Operator mockOperator(String name, String phone, String email, String observation) {
		Operator operator = new Operator();
		operator.setName(name);
		operator.setEmail(email);
		operator.setPhone(phone);
		operator.setObservation(observation);
		return operator;
	}
	

}
