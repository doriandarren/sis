package com.app.sis.operator;

import org.junit.After;
import org.junit.Before;

import com.app.api.model.Operator;
import com.app.sis.incidense.TestBaseIncidense;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

public class TestBaseOperator extends TestBaseIncidense{
	
	protected static final String NAME_OPERATOR = "Wilmer Lopez";
	protected static final String PHONE_OPERATOR = "+589633323";
	protected static final String EMAIL_OPERATOR = "wilmer_lopez@gmail.com";
	protected static final String OBSERVATION_OPERATOR = "Plomero, Albañil, Otros";
	
	protected static final String NAME_OPERATOR_UPDATE = "Kile Zapp";
	protected static final String PHONE_OPERATOR_UPDATE = "+589002020";
	protected static final String EMAIL_OPERATOR_UPDATE = "killzapp@ies.com";
	protected static final String OBSERVATION_OPERATOR_UPDATE = "Manitas, Otros";
	
	
	protected final LocalServiceTestHelper helper =
		      new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());
		 
	@Before
	public void setUp() {
		helper.setUp();		
	}

	@After
	public void tearDown() {
		helper.tearDown();
	}
		
	
	protected Operator getMockOperator() {
		return getMockOperator(NAME_OPERATOR, PHONE_OPERATOR, EMAIL_OPERATOR,
				OBSERVATION_OPERATOR);
	}
	
	
	protected Operator getMockOperator(String name, String phone, String email, 
									String observation) {
		Operator operator = new Operator();
		operator.setName(name);
		operator.setEmail(email);
		operator.setPhone(phone);
		operator.setObservation(observation);
		return operator;
	}
	
}
