package com.formation.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formation.mvc.entities.CategorieEntity;

@Repository
public interface CategorieRepository extends JpaRepository<CategorieEntity, Long> {
	
	public CategorieEntity  findByCatigorieId(String catigorieId);

}
