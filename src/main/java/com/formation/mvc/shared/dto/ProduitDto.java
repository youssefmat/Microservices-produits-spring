package com.formation.mvc.shared.dto;

import java.io.Serializable;


public class ProduitDto implements Serializable {

	
	private static final long serialVersionUID = 7471037853754402974L;
	private Long id;
	private String produitId;
	private String name;
	private String description;
	private Double currentPrice;
	private boolean promotime=false;
	private boolean selected=false;
	private boolean avalable=false;
	private String photoName;
	private CategorieDto categorieDto;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public CategorieDto getCategorieDto() {
		return categorieDto;
	}
	public void setCategorieDto(CategorieDto categorieDto) {
		this.categorieDto = categorieDto;
	}

}
