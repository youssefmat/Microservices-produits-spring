package com.formation.mvc.services.impl;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.formation.mvc.entities.CategorieEntity;
import com.formation.mvc.repository.CategorieRepository;
import com.formation.mvc.responses.CategorieResponse;
import com.formation.mvc.services.CategorieServices;
import com.formation.mvc.shared.Utils;
import com.formation.mvc.shared.dto.CategorieDto;

@Service
public class CategorieServiceImp implements CategorieServices  {
  
   @Autowired	
   CategorieRepository  categorieRepositry;
   
   @Autowired
   Utils utils;
  
	@Override
	public CategorieDto createCategorie(CategorieDto categorieDto) {
		ModelMapper modelMapper = new ModelMapper();
		CategorieEntity categorieEntity= modelMapper.map(categorieDto, CategorieEntity.class);
		categorieEntity.setCatigorieId(utils.genereteStringId(32));
		CategorieEntity newCategorie = categorieRepositry.save(categorieEntity);
		CategorieDto categorieCreated = modelMapper.map(newCategorie, CategorieDto.class);
		return categorieCreated;
	}

	@Override
	public List<CategorieDto> getAllCategorie() {
		
		List<CategorieEntity> listCategories =categorieRepositry.findAll();
		
		Type listType = new TypeToken<List<CategorieDto>>() {}.getType();
		List<CategorieDto> categoriesDto = new ModelMapper().map(listCategories, listType);
		return categoriesDto;
	}

	@Override
	public CategorieDto updatedCategorie(String id, CategorieDto categorieDto) {
		CategorieEntity checkCategorie = categorieRepositry.findByCatigorieId(id);
		if(checkCategorie == null) throw new RuntimeException("cette categorie n'existe pas !");
		checkCategorie.setName(categorieDto.getName());
		CategorieEntity newCategorie = categorieRepositry.save(checkCategorie);
		ModelMapper modelMapper = new ModelMapper();
		CategorieDto categorieCreated = modelMapper.map(newCategorie, CategorieDto.class);
		return categorieCreated;
	}

	@Override
	public void deleteCategorie(String id) {
		 CategorieEntity checkCategorie = categorieRepositry.findByCatigorieId(id);
		if(checkCategorie == null) throw new RuntimeException("cette categorie n'existe pas !");	
		categorieRepositry.delete(checkCategorie);
	}
	
	

}
