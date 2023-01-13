package com.formation.mvc.services;

import java.util.List;


import com.formation.mvc.shared.dto.ProduitDto;

public interface ProduitService {
	
	public ProduitDto createProduit(String id,ProduitDto produitDto);
	public List<ProduitDto> getAllProduits();
	public ProduitDto updatedProduit(String id ,ProduitDto produitDto);
	public void deleteProduit(String id);
	public ProduitDto updatePhotoProduit(String id,String PhotoName);

}
