package com.app.api.datastore;

import java.util.List;

import javax.persistence.EntityManager;

import com.app.api.model.Incidense;
import com.app.api.model.Operator;
import com.google.appengine.api.datastore.Key;
import com.sun.istack.NotNull;

public class DAOOperator implements DAOInf, DAOInf.InfCRUDRelation<Operator>{
	
	@Override
	public void create(@NotNull Key keyIncidense, @NotNull Operator operator) {
		if(operator==null) {
			throw new IllegalArgumentException("> El operator no puede ser null");
		}
		
		EntityManager em = EMF.get().createEntityManager();
			Incidense incidense = em.find(Incidense.class, keyIncidense);
			em.persist(operator);
			operator.setIncidense(incidense);
			incidense.getListOperator().add(operator);
		em.close();	
	}


	@Override
	public void delete(@NotNull Key key) {
		EntityManager em = EMF.get().createEntityManager();
		Operator operator = em.find(Operator.class, key);
		Incidense incidense = em.find(Incidense.class, operator.getIncidense().getKey());
		incidense.getListOperator().remove(operator);
		em.close();
	}


	@Override
	public void update(@NotNull Operator operator) {
		if(operator==null) {
			throw new IllegalArgumentException("> El operator no puede ser null");
		}		
		
		EntityManager em = EMF.get().createEntityManager();
				
			Operator operatorOld = em.find(Operator.class, operator.getKey());
		
			if (operator.getName() != null && 
					!operator.getName().equals("")) {
				operatorOld.setName(operator.getName());
			}
	
			if (operator.getEmail() != null && 
					!operator.getEmail().equals("")) {
				operatorOld.setEmail(operator.getEmail());
			}
	
			if (operator.getPhone() != null && 
					!operator.getPhone().equals("")) {
				operatorOld.setPhone(operator.getPhone());
			}
	
			if (operator.getObservation() != null && 
					!operator.getObservation().equals("")) {
				operatorOld.setObservation(operator.getObservation());
			}
		
		em.merge(operatorOld);
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
