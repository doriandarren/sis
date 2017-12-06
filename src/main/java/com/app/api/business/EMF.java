package com.app.api.business;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMF {

	private static final EntityManagerFactory emfInstance = Persistence
	        .createEntityManagerFactory("persistence_unit");

	private EMF() {
	}

	public static EntityManagerFactory get() {
		return emfInstance;
	}
}
