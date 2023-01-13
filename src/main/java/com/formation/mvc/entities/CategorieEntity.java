package com.formation.mvc.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity(name = "categorie")
public class CategorieEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, length = 32)
	private String catigorieId;
	@Column(nullable = false, length = 20)
	private String name;
	
	@OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL)
	private List<ProduitEntity> produits;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCatigorieId() {
		return catigorieId;
	}
	public void setCatigorieId(String catigorieId) {
		this.catigorieId = catigorieId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<ProduitEntity> getProduits() {
		return produits;
	}
	public void setProduits(List<ProduitEntity> produits) {
		this.produits = produits;
	}

}
