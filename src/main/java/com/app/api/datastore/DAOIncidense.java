package com.app.api.datastore;

import java.util.List;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;

import com.app.api.model.Incidense;
import com.app.api.model.Place;
import com.google.appengine.api.datastore.Key;

public class DAOIncidense implements DAOInf, DAOInf.InfCRUDRelation<Incidense> {
	
	@Override
	public void create(@NotNull Key keyPlace, @NotNull Incidense incidense) {
		if(incidense==null) {
			throw new IllegalArgumentException("> El incidense no puede ser null");
		}			
		EntityManager em = EMF.get().createEntityManager();		
			Place placeFind = em.find(Place.class, keyPlace);
			em.persist(incidense);
			incidense.setPlace(placeFind);
			placeFind.getListIncidense().add(incidense);
		em.close();			
	}

	@Override
	public void delete(@NotNull Key key) {
		EntityManager em = EMF.get().createEntityManager();
		Incidense incidense = em.find(Incidense.class, key);
		Place place = em.find(Place.class, incidense.getPlace().getKey());
		place.getListIncidense().remove(incidense);
		em.close();			
	}

	@Override
	public void update(@NotNull Incidense incidense) {
		if(incidense==null) {
			throw new IllegalArgumentException("> El incidense no puede ser null");
		}	
		
		EntityManager em = EMF.get().createEntityManager();
		
		Incidense incidenseOld = em.find(Incidense.class, incidense.getKey());
		
		if (incidense.getDescription() != null && 
				!incidense.getDescription().equals("")) {
			incidenseOld.setDescription(incidense.getDescription());
		}	
		
		if (incidense.getNumberAlbaran() != null && 
				!incidense.getNumberAlbaran().equals("")) {
			incidenseOld.setNumberAlbaran(incidense.getNumberAlbaran());
		}
		
		if (incidense.getCreateAt() != null && 
				!incidense.getCreateAt().equals(null)) {
			incidenseOld.setCreateAt(incidense.getCreateAt());
		}
		
		if (incidense.getAtentionAt() != null && 
				!incidense.getAtentionAt().equals(null)) {
			incidenseOld.setAtentionAt(incidense.getAtentionAt());
		}
		
		if (incidense.getCloseAt() != null && 
				!incidense.getCloseAt().equals(null)) {
			incidenseOld.setCloseAt(incidense.getCloseAt());
		}
		
		if (incidense.getStatus() != null && 
				!incidense.getStatus().equals("")) {
			incidenseOld.setStatus(incidense.getStatus());		}		
		
		em.merge(incidenseOld);
		em.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	/*

	@Override
	public void delete(@NotNull Key key) {
		EntityManager em = EMF.get().createEntityManager();
		Incidense incidense = em.find(Incidense.class, key);
		em.remove(incidense);
		em.close();	
	}

	@Override
	public void update(@NotNull Incidense incidense) {
		if(incidense==null) {
			throw new IllegalArgumentException("> El incidense no puede ser null");
		}		
		
		EntityManager em = EMF.get().createEntityManager();
		Incidense incidenseOld = em.find(Incidense.class, incidense.getKey());
		
		if (incidense.getDescription() != null && 
				!incidense.getDescription().equals("")) {
			incidenseOld.setDescription(incidense.getDescription());
		}
		//TODO faltan los demas campos
		
		em.merge(incidenseOld);
		em.close();
		
	}*/

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
