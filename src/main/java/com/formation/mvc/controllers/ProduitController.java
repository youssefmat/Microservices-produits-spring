package com.formation.mvc.controllers;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.formation.mvc.requests.ProduitRequest;
import com.formation.mvc.responses.ProduitResponse;
import com.formation.mvc.services.ProduitService;
import com.formation.mvc.shared.dto.ProduitDto;

@RestController
@RequestMapping("/produits")
public class ProduitController {
	
	@Autowired
	ProduitService produitService;
	
	@GetMapping
    public ResponseEntity<List<ProduitResponse>> getProduits(){
		
		List<ProduitDto> produitsDto =  produitService.getAllProduits();
		
		Type listType = new TypeToken<List<ProduitResponse>>() {}.getType();
		List<ProduitResponse> produitsResponse = new ModelMapper().map(produitsDto, listType);
		
		return new ResponseEntity<List<ProduitResponse>>( produitsResponse,HttpStatus.OK);
		
	 }
	
	
	    //(consumes={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
	   //produces={MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	@PostMapping(path="/{produitId}", consumes= {MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE})
	public ResponseEntity<ProduitResponse> addProduit(@PathVariable String produitId, @RequestBody ProduitRequest produitRequest){
	    
		//if(file.isEmpty()) throw new RuntimeException("le fichier est vide !!");
		
	ModelMapper modelMapper = new ModelMapper();
	ProduitDto produitDto = modelMapper.map(produitRequest, ProduitDto.class);
	produitDto.setPhotoName("test Name photo?");
	ProduitDto createProduit= produitService.createProduit(produitId,produitDto);
	
	ProduitResponse produitResponse = modelMapper.map(createProduit, ProduitResponse.class);
	return new  ResponseEntity<ProduitResponse>(produitResponse,HttpStatus.CREATED);
	}
	
	@PutMapping(path = "/{id}")
	   public ResponseEntity<ProduitResponse> updateProduit(@PathVariable String id, @RequestBody ProduitRequest produitRequest){
			ModelMapper modelMapper = new ModelMapper();
			ProduitDto produitDto = modelMapper.map(produitRequest, ProduitDto.class);
			ProduitDto createProduit= produitService.updatedProduit(id,produitDto);
			
			ProduitResponse produitResponse = modelMapper.map(createProduit, ProduitResponse.class);
			return new  ResponseEntity<ProduitResponse>(produitResponse,HttpStatus.CREATED);
		   
	   }
		
		@DeleteMapping(path="/{id}")
		public ResponseEntity<Object> deleteProduit(@PathVariable String id) {
			produitService.deleteProduit(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

}
