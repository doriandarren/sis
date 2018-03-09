package com.app.api.datastore;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;

import com.app.api.model.Client;
import com.app.api.model.Place;
import com.google.appengine.api.datastore.Key;

public class DAOPlace implements DAOInf, DAOInf.InfCRUDRelation<Place>{

	@Override
	public void create(@NotNull Key keyClient, @NotNull Place place) {
		if(keyClient==null) {
			throw new IllegalArgumentException("> El Key client no puede ser null");
		}	
		
		EntityManager em = EMF.get().createEntityManager();
		Client client = em.find(Client.class, keyClient);
		em.persist(place);
		place.setClient(client);
		client.getListPlace().add(place);
		em.close();
		
		/*try {
	        emF.getTransaction().begin();	        
	        Client client = emF.find(Client.class, keyClient);
			emF.persist(place);
			place.setClient(client);
			client.getListPlace().add(place);	        
	        emF.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
	    } finally {
	    	emF.close();
	    }*/
		
		
		//List<Place> list = client.getListPlace();
		//System.out.println(list.get(0).getName());
		
		
		//EntityManager em = EMF.get().createEntityManager();	
		//em.persist(place);
				
		//em.close();
		
	}


	@Override
	public void delete(@NotNull Key key) {
		EntityManager em = EMF.get().createEntityManager();
		Place place = em.find(Place.class, key);
		Client client = em.find(Client.class, place.getClient().getKey());
		client.getListPlace().remove(place);
		em.close();	
	}


	@Override
	public void update(@NotNull Place place) {
		
		if(place==null) {
			throw new IllegalArgumentException("> El Place no puede ser null");
		}
		
		EntityManager em = EMF.get().createEntityManager();
		
		Place placeOld = em.find(Place.class, place.getKey());
		
		if (place.getName() != null && 
				!place.getName().equals("")) {
			placeOld.setName(place.getName());
		}
		
		if (place.getAddress() != null && 
				!place.getAddress().equals("")) {
			placeOld.setAddress(place.getAddress());
		}
		
		if (place.getDescription() != null && 
				!place.getDescription().equals("")) {
			placeOld.setDescription(place.getDescription());
		}
		
		
		if (place.getPhone() != null && 
				!place.getPhone().equals("")) {
			placeOld.setPhone(place.getPhone());
		}
		
				
		if (place.getEmail() != null && 
				!place.getEmail().equals("")) {
			placeOld.setEmail(place.getEmail());
		}
		
		if (place.getCodeZip() != null && 
				!place.getCodeZip().equals("")) {
			placeOld.setCodeZip(place.getCodeZip());
		}
		
		if (place.getCity() != null && 
				!place.getCity().equals("")) {
			placeOld.setCity(place.getCity());
		}		
				
		em.merge(placeOld);
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
