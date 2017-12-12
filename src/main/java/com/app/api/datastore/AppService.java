package com.app.api.datastore;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import com.app.api.model.Operator;
import com.sun.istack.NotNull;

public class AppService implements InfAppService {
	
	//@PersistenceContext(unitName = "persistence_unit")
	//private EntityManager em;
	
	//private EntityManager em;
	
	
	
	@Override
	public void loginUser(@NotNull String email, @NotNull String password) {
		if(email==null) 
			throw new IllegalArgumentException("> El email no puede ser null");
		if(password==null) 
			throw new IllegalArgumentException("> El password no puede ser null");
		
		//TODO falta autenticacion con google
		
		
	}

	
	@Override
	public void addOperator(@NotNull Operator operator) {		
		if(operator==null) {
			throw new IllegalArgumentException("> El operator no puede ser null");
		}		
		EntityManager em = EMF.get().createEntityManager();
		
		try {
            em.getTransaction().begin();
            em.persist(operator);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
        	em.close();
        }
	}

	@Override
	public void updateOperator(Operator operator) {
		
		if(operator==null) {
			throw new IllegalArgumentException("> El operator no puede ser null");
		}		
		
		EntityManager em = EMF.get().createEntityManager();
		em.getTransaction().begin();
		
			Operator operatorOld = em.find(Operator.class, operator.getId());
		
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
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void removeOperator(@NotNull String operatorId) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	
	/***
	 * Service for to all
	 */
	
	@Override
	public <T> T find(Class<T> clazz, Object id) {
		EntityManager em = EMF.get().createEntityManager();
		return em.find(clazz, id);
	}


	@Override
	public <T> List<T> findAll(Class<T> clazz) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
