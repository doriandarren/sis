package com.app.api.datastore;

import java.util.List;

import com.app.api.model.Operator;

public interface InfAppService {

	public void loginUser(String email, String password);
	
	
	public void addOperator(Operator operator);
	public void updateOperator(Operator operator);
	public void removeOperator(String operatorId);
	
	
	
	public  <T> T find(Class< T> clazz,Object id);
	public  <T> List<T> findAll(Class< T> clazz);
	
}
