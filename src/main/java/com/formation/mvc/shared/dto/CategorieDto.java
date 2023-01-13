package com.formation.mvc.shared.dto;

import java.io.Serializable;
import java.util.List;




public class CategorieDto implements Serializable {

	
	private static final long serialVersionUID = -862506666060714324L;
	private Long id;
	private String categorieId;
	private String name;
	private String photoName;
	private List<ProduitDto> produits;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCatigorieId() {
		return categorieId;
	}
	public void setCatigorieId(String categorieId) {
		this.categorieId = categorieId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhotoName() {
		return photoName;
	}
	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}
	public List<ProduitDto> getProduits() {
		return produits;
	}
	public void setProduits(List<ProduitDto> produits) {
		this.produits = produits;
	}
	
	

}
