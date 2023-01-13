package com.formation.mvc.controllers;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formation.mvc.requests.CategorieRequest;
import com.formation.mvc.responses.CategorieResponse;
import com.formation.mvc.services.CategorieServices;
import com.formation.mvc.shared.dto.CategorieDto;

@RestController
@RequestMapping("/categories")
public class CategorieController {
	
	@Autowired
	CategorieServices categorieService;
	
	              //(consumes={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
			     //produces={MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	@PostMapping
	public ResponseEntity<CategorieResponse> addCategorie(@RequestBody CategorieRequest categorieRequest){
		
		ModelMapper modelMapper = new ModelMapper();
		CategorieDto categorieDto = modelMapper.map(categorieRequest, CategorieDto.class);
		CategorieDto createCategorie= categorieService.createCategorie(categorieDto);
		
		CategorieResponse categorieResponse = modelMapper.map(createCategorie, CategorieResponse.class);
		return new  ResponseEntity<CategorieResponse>(categorieResponse,HttpStatus.CREATED);
	}
	
	@GetMapping(produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<CategorieResponse>> getCategories(){
		
		List<CategorieDto> categoriesDto =  categorieService.getAllCategorie();
		
		Type listType = new TypeToken<List<CategorieResponse>>() {}.getType();
		List<CategorieResponse> categoriesResponse = new ModelMapper().map(categoriesDto, listType);
		
		return new ResponseEntity<List<CategorieResponse>>( categoriesResponse,HttpStatus.OK);
		
	}
	
	@PutMapping(path = "/{id}")
   public ResponseEntity<CategorieResponse> updateCategorie(@PathVariable String id, @RequestBody CategorieRequest categorieRequest){
		ModelMapper modelMapper = new ModelMapper();
		CategorieDto categorieDto = modelMapper.map(categorieRequest, CategorieDto.class);
		CategorieDto createCategorie= categorieService.updatedCategorie(id,categorieDto);
		
		CategorieResponse categorieResponse = modelMapper.map(createCategorie, CategorieResponse.class);
		return new  ResponseEntity<CategorieResponse>(categorieResponse,HttpStatus.CREATED);
	   
   }
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Object> deleteCategorie(@PathVariable String id) {
		categorieService.deleteCategorie(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
