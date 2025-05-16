package com.example.agendinaBE.repository;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import com.example.agendinaBE.model.DipendentiEntity;


public interface DipendentiRepository extends JpaRepository<DipendentiEntity, Long>{
	
	@Query(value="Select * from dipendenti where id = :id", nativeQuery = true)
	public DipendentiEntity prendiId(@Param("id") Long dipendentiId);
	
}