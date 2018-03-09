
package com.app.api.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.google.appengine.api.datastore.Key;

@Entity
public class Place {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Key key;
	private String name;
	private String address;
	private String description;
	private String phone;
	private String email;
		
	private String codeZip;
	private String city;
		
	@ManyToOne
	//@JoinColumn(name="client_id")
 	private Client client;

	
	@OneToMany(mappedBy="place"
		 	,fetch=FetchType.EAGER
	 		,cascade={CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.DETACH}
	 			,orphanRemoval=true
	 		)
	private List<Incidense> listIncidense = new ArrayList<>();


	public Key getKey() {
		return key;
	}


	public String getName() {
		return name;
	}


	public String getAddress() {
		return address;
	}


	public String getDescription() {
		return description;
	}


	public String getPhone() {
		return phone;
	}


	public String getEmail() {
		return email;
	}


	public String getCodeZip() {
		return codeZip;
	}


	public String getCity() {
		return city;
	}


	public Client getClient() {
		return client;
	}


	public List<Incidense> getListIncidense() {
		return listIncidense;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setCodeZip(String codeZip) {
		this.codeZip = codeZip;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public void setListIncidense(List<Incidense> listIncidense) {
		this.listIncidense = listIncidense;
	}
	
}
