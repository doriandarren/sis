package com.app.sis.place;

import org.junit.After;
import org.junit.Before;

import com.app.api.model.Place;
import com.app.sis.client.TestBaseClient;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

public class TestBasePlace extends TestBaseClient {

	
	protected static final String NAME_PLACE = "Paseo de Gracia 12";
	protected static final String ADDRESS_PLACE = "Paseo de gracia 12, 08010";
	protected static final String DESCRIPTION_PLACE = "NINGUNA";
	protected static final String PHONE_PLACE = "+34652336622";
	protected static final String EMAIL_PLACE = "gucci_paseo@gucci.it";
	protected static final String CODE_ZIP_PLACE = "08011";
	protected static final String CITY_PLACE = "Barcelona";
	
	
	
	protected static final String NAME_PLACE_UPDATE = "Paseo de Gracia 24";
	protected static final String ADDRESS_PLACE_UPDATE = "Paseo de gracia 24, 08010";
	protected static final String DESCRIPTION_PLACE_UPDATE = "otro";
	protected static final String PHONE_PLACE_UPDATE = "+34707858585";
	protected static final String EMAIL_PLACE_UPDATE = "ppaseogucci@gucci.com";
	protected static final String CODE_ZIP_PLACE_UPDATE = "08011";
	protected static final String CITY_PLACE_UPDATE = "Barcelona";
	
	
	
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
	
	protected Place getMockPlace() {
		return getMockPlace(NAME_PLACE, ADDRESS_PLACE, DESCRIPTION_PLACE, 
							PHONE_PLACE, EMAIL_PLACE, CODE_ZIP_PLACE, CITY_PLACE);
	}

	protected Place getMockPlace(String name, String address, String description, 
								String phone, String email, String codeZip, String city) {
		
		Place place = new Place();
		place.setName(name);
		place.setAddress(address);
		place.setDescription(description);
		place.setPhone(phone);
		place.setEmail(email);
		place.setCodeZip(codeZip);
		place.setCity(city);
		return place;
	}
	
	
	
}
