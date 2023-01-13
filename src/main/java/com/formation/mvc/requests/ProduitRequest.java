package com.formation.mvc.requests;

import java.io.Serializable;


public class ProduitRequest implements Serializable{

	
	private static final long serialVersionUID = 6054340938253489245L;
	
	private String name;
	private String description;
	private Double currentPrice;
	private String photoName;
    
	
	 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(Double currentPrice) {
		this.currentPrice = currentPrice;
	}
	public String getPhotoName() {
		return photoName;
	}
	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}
}
