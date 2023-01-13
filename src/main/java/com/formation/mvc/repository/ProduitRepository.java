package com.formation.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formation.mvc.entities.ProduitEntity;

public interface ProduitRepository extends JpaRepository<ProduitEntity, Long> {
	public ProduitEntity  findByProduitId(String produitId);


}
