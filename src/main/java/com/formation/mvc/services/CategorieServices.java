package com.formation.mvc.services;

import java.util.List;

import com.formation.mvc.shared.dto.CategorieDto;

public interface CategorieServices {
	
	public CategorieDto createCategorie(CategorieDto categorieDto);
	public List<CategorieDto> getAllCategorie();
	public CategorieDto updatedCategorie(String id ,CategorieDto categorieDto);
	public void deleteCategorie(String id);

}
