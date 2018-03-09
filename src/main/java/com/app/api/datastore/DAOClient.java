package com.app.api.datastore;

import java.util.List;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;

import com.app.api.model.Client;
import com.google.appengine.api.datastore.Key;

public class DAOClient implements DAOInf, DAOInf.InfCRUD<Client> {

	@Override
	public void create(@NotNull Client client) {
		if(client==null) {
			throw new IllegalArgumentException("> El client no puede ser null");
		}		
		EntityManager em = EMF.get().createEntityManager();
		em.persist(client);
		em.close();	
	}

	@Override
	public void delete(Key key) {
		EntityManager em = EMF.get().createEntityManager();
		Client clientFind = em.find(Client.class, key);
		em.remove(clientFind);
		em.close();
	}

	@Override
	public void update(Client client) {
		if(client==null) {
			throw new IllegalArgumentException("> El client no puede ser null");
		}
		
		EntityManager em = EMF.get().createEntityManager();
		Client clientOld = em.find(Client.class, client.getKey());
		
		if (client.getName() != null && 
				!client.getName().equals("")) {
			clientOld.setName(client.getName());
		}
		
		if (client.getDescription() != null && 
				!client.getDescription().equals("")) {
			clientOld.setDescription(client.getDescription());
		}
		
		if (client.getCreateAt() != null && 
				!client.getCreateAt().equals(null)) {
			clientOld.setCreateAt(client.getCreateAt());
		}
		
		em.merge(clientOld);
		em.close();
		
	}

	
	
	/***
	 * Service for to all
	 */
	
	@Override
	public <T> T find(Class<T> clazz, Object id) {
		EntityManager em = EMF.get().createEntityManager();
		return em.find(clazz, id);
	}


	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> findAll(Class<T> clazz) {
		String className = clazz.getSimpleName();
		EntityManager em = EMF.get().createEntityManager();
		return em.createQuery("SELECT o FROM " + className  + " o")
				.getResultList();
	}

}
