package com.app.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import com.google.appengine.api.datastore.Key;

@Entity
public class Operator {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Key key;	
	private String name;
	private String phone;
	private String email;
	private String observation;
	
	@ManyToOne
 	private Incidense incidense;
	
	
	//GETER SETER
	
	public Key getKey() {
		return key;
	}


	public String getName() {
		return name;
	}


	public String getPhone() {
		return phone;
	}


	public String getEmail() {
		return email;
	}


	public String getObservation() {
		return observation;
	}


	public Incidense getIncidense() {
		return incidense;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setObservation(String observation) {
		this.observation = observation;
	}


	public void setIncidense(Incidense incidense) {
		this.incidense = incidense;
	}
	
}
