package com.formation.mvc.requests;

import java.util.List;



public class CategorieRequest  { 


	private String name;
	private List<ProduitRequest> produits;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<ProduitRequest> getProduits() {
		return produits;
	}
	public void setProduits(List<ProduitRequest> produits) {
		this.produits = produits;
	}

}
