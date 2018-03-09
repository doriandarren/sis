package com.app.api.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.google.appengine.api.datastore.Key;

@Entity
public class Client {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Key key;
	private String name;
	private String description;
	private Date createAt;
		
	@Transient
	private String id;
	
	
	@OneToMany(mappedBy="client"
		 	,fetch=FetchType.EAGER
	 		,cascade={CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.DETACH}
	 			,orphanRemoval=true
	 		)
    private List<Place> listPlace = new ArrayList<Place>();


	public Key getKey() {
		return key;
	}


	public String getName() {
		return name;
	}


	public String getDescription() {
		return description;
	}


	public Date getCreateAt() {
		return createAt;
	}


	public String getId() {
		return id;
	}


	public List<Place> getListPlace() {
		return listPlace;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}


	public void setId(String id) {
		this.id = id;
	}


	public void setListPlace(List<Place> listPlace) {
		this.listPlace = listPlace;
	}
	
}
