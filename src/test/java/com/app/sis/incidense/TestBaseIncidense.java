package com.app.sis.incidense;

import java.util.Date;

import org.junit.After;
import org.junit.Before;

import com.app.api.model.Incidense;
import com.app.sis.place.TestBasePlace;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

public class TestBaseIncidense extends TestBasePlace {
	
	protected static final String DESCRIPTION_INCIDENSE = "Problema en algun lado";
	protected static final String NUMBER_ALBARAN_INCIDENSE = "5410";
	protected static final Date CREATE_AT_INCIDENSE = new Date();
	protected static final Date ATENTION_AT_INCIDENSE = new Date();
	protected static final Date CLOSE_AT_INCIDENSE = new Date();
	protected static final String STATUS_INCIDENSE = "1";
	
	protected static final String DESCRIPTION_INCIDENSE_UPDATE = "Problema otro lado";
	protected static final String NUMBER_ALBARAN_INCIDENSE_UPDATE = "2020";
	protected static final Date CREATE_AT_INCIDENSE_UPDATE = new Date();
	protected static final Date ATENTION_AT_INCIDENSE_UPDATE = new Date();
	protected static final Date CLOSE_AT_INCIDENSE_UPDATE = new Date();
	protected static final String STATUS_INCIDENSE_UPDATE = "2";
	
		
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
			
	protected Incidense getMockIncidcense() {
		return getMockIncidense(DESCRIPTION_INCIDENSE, 
				NUMBER_ALBARAN_INCIDENSE, CREATE_AT_INCIDENSE, 
				ATENTION_AT_INCIDENSE, CLOSE_AT_INCIDENSE, STATUS_INCIDENSE);
	}

	protected Incidense getMockIncidense(String description, String numberAlbaran, 
									Date createAt, Date atentionAt, Date closeAt,
									String status) {
		
		Incidense incidense = new Incidense();
		incidense.setDescription(description);
		incidense.setNumberAlbaran(numberAlbaran);
		incidense.setCreateAt(createAt);
		incidense.setAtentionAt(atentionAt);
		incidense.setCloseAt(closeAt);		
		incidense.setStatus(status);
		return incidense;
	}
	
}
