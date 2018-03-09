package com.app.api.datastore;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.app.api.model.Client;
import com.google.appengine.api.datastore.Key;

public interface DAOInf {
	
	public interface InfCRUD<T>{
		public void create(@NotNull T clazz);
		public void delete(@NotNull Key key);	
		public void update(@NotNull T clazz);			
	}
	
	
	public interface InfCRUDRelation<T>{
		public void create(@NotNull Key keyClient, @NotNull T clazz);
		public void delete(@NotNull Key key);
		public void update(@NotNull T clazz);
	}
		
	public <T> T find(Class<T> clazz,Object id);
	public <T> List<T> findAll(Class<T> clazz);
	
}
