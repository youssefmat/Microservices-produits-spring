package com.formation.mvc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "produits")
public class ProduitEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable=false, length = 32)
	private String produitId;
	@Column(nullable = false,length = 20)
	private String name;
	@Column(nullable = false,length = 200)
	private String description;
	@Column(nullable = false)
	private Double currentPrice;
	@Column(nullable=false)
	private boolean promotime=false;
	@Column(nullable=false)
	private boolean selected=false;
	@Column(nullable=false)
	private boolean avalable=false;
	@Column(nullable = false)
	private String photoName;
	@ManyToOne
	@JoinColumn
	private CategorieEntity categorie;
	
	
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
	public CategorieEntity getCategorie() {
		return categorie;
	}
	public void setCategorie(CategorieEntity categorie) {
		this.categorie = categorie;
	}

}
