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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.google.appengine.api.datastore.Key;

@Entity
public class Incidense {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Key key;
	
	private String description;
	private String numberAlbaran;
	private Date createAt;
	private Date atentionAt;
	private Date closeAt; 
	private String status;	
		
	@OneToMany(mappedBy="incidense"
		 	,fetch=FetchType.EAGER
	 		,cascade={CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.DETACH}
	 			//,orphanRemoval=true
	 		)
 	private List<Operator> listOperator = new ArrayList<>();
	
	
	@ManyToOne
	private Place place;

	

	//GETER SETER
	
	public Key getKey() {
		return key;
	}


	public String getDescription() {
		return description;
	}


	public String getNumberAlbaran() {
		return numberAlbaran;
	}


	public Date getCreateAt() {
		return createAt;
	}


	public Date getAtentionAt() {
		return atentionAt;
	}


	public Date getCloseAt() {
		return closeAt;
	}


	public List<Operator> getListOperator() {
		return listOperator;
	}

	
	public Place getPlace() {
		return place;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public void setNumberAlbaran(String numberAlbaran) {
		this.numberAlbaran = numberAlbaran;
	}


	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}


	public void setAtentionAt(Date atentionAt) {
		this.atentionAt = atentionAt;
	}


	public void setCloseAt(Date closeAt) {
		this.closeAt = closeAt;
	}


	public void setListOperator(List<Operator> listOperator) {
		this.listOperator = listOperator;
	}
	
	public void setPlace(Place place) {
		this.place = place;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
}
