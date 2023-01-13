package com.formation.mvc.services.impl;

import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.mapping.Map;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.mvc.entities.CategorieEntity;
import com.formation.mvc.entities.ProduitEntity;
import com.formation.mvc.repository.CategorieRepository;
import com.formation.mvc.repository.ProduitRepository;
import com.formation.mvc.services.ProduitService;
import com.formation.mvc.shared.Utils;
import com.formation.mvc.shared.dto.CategorieDto;
import com.formation.mvc.shared.dto.ProduitDto;

@Service
public class ProduitServiceImpl implements ProduitService{
	
	@Autowired
	ProduitRepository produitRepository;
	@Autowired
	CategorieRepository  categorieRepository;
	@Autowired
	Utils utils;

	@Override
	public ProduitDto createProduit(String id , ProduitDto produitDto) {
		ModelMapper modelMapper = new ModelMapper();
		CategorieEntity checkCategorie = categorieRepository.findByCatigorieId(id);
		if(checkCategorie == null) throw new RuntimeException("cette categorie n'existe pas!");
		
		
		ProduitEntity produitEntity = modelMapper.map(produitDto, ProduitEntity.class);
		produitEntity.setProduitId(utils.genereteStringId(32));
		produitEntity.setCategorie(checkCategorie);
		ProduitEntity newProduit = produitRepository.save(produitEntity);
		ProduitDto newProduitDto = modelMapper.map(newProduit, ProduitDto.class);
		return newProduitDto;
	}

	@Override
	public List<ProduitDto> getAllProduits() {
        
		List<ProduitEntity> listProduits = produitRepository.findAll();
		
		Type listType = new TypeToken<List<ProduitDto>>() {}.getType();
		List<ProduitDto> produitsDto = new ModelMapper().map(listProduits, listType);
		return produitsDto;
	}

	@Override
	public ProduitDto updatedProduit(String id, ProduitDto produitDto) {
		ProduitEntity checkProduit = produitRepository.findByProduitId(id);
		if(checkProduit == null) throw new RuntimeException("cette produit n'existe pas !");
		checkProduit.setName(produitDto.getName());
		checkProduit.setDescription(produitDto.getDescription());
		checkProduit.setCurrentPrice(produitDto.getCurrentPrice());
		checkProduit.setPhotoName(produitDto.getPhotoName());
		ProduitEntity newProduit = produitRepository.save(checkProduit);
		ModelMapper modelMapper = new ModelMapper();
		ProduitDto produitCreated = modelMapper.map(newProduit, ProduitDto.class);
		return produitCreated;
	}

	@Override
	public void deleteProduit(String id) {
		
		ProduitEntity checkProduit = produitRepository.findByProduitId(id);
		if(checkProduit == null) throw new RuntimeException("cette produit n'existe pas !");
		produitRepository.delete(checkProduit);
		
	}

	@Override
	public ProduitDto updatePhotoProduit(String id,String photoName) {
		ProduitEntity checkProduit = produitRepository.findByProduitId(id);
		checkProduit.setPhotoName(photoName);
		ProduitEntity produitUpdated = produitRepository.save(checkProduit);
		ModelMapper modelMapper = new ModelMapper();
		ProduitDto produitDtoUpdated = modelMapper.map(produitUpdated, ProduitDto.class);
		return produitDtoUpdated;
	}

}
