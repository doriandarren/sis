package com.app.sis.client;

import java.util.Date;

import org.junit.After;
import org.junit.Before;

import com.app.api.model.Client;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

public class TestBaseClient {

	protected static final String NAME = "GUCCI";
	protected static final String DESCRIPTION = "Tienda Mayorista";
	protected static final Date CREATE_AT = new Date();
	
	protected static final String NAME_UPDATE = "MACA";
	protected static final String DESCRIPTION_UPDATE = "LA MEJOR";
	protected static final Date CREATE_AT_UPDATE = new Date();
	
	
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
	
	protected Client getMockClient() {
		return getMockClient(NAME,DESCRIPTION,CREATE_AT);
	}

	protected Client getMockClient(String name, String description, Date createAt) {
		Client client = new Client();
		client.setName(name);
		client.setDescription(description);
		client.setCreateAt(createAt);
		return client;
	}
	
	
}
