package com.formation.mvc.responses;


public class ProduitResponse {
	
	private String produitId;
	private String name;
	private String description;
	private Double currentPrice;
	private boolean promotime;
	private boolean selected;
	private boolean avalable;
	private String photoName;
	
	public String getProduitId() {
		return produitId;
	}
	public void setProduitId(String produitId) {
		this.produitId = produitId;
	}
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
	public boolean isPromotime() {
		return promotime;
	}
	public void setPromotime(boolean promotime) {
		this.promotime = promotime;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	public boolean isAvalable() {
		return avalable;
	}
	public void setAvalable(boolean avalable) {
		this.avalable = avalable;
	}
	public String getPhotoName() {
		return photoName;
	}
	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}
	
	

}
