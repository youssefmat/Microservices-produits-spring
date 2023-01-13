package com.formation.mvc.responses;



public class CategorieResponse {
    
	private String categorieId;
	private String name;
	//private List<ProduitResponse> produits;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategorieId() {
		return categorieId;
	}
	public void setCategorieId(String categorieId) {
		this.categorieId = categorieId;
	}
	

}
