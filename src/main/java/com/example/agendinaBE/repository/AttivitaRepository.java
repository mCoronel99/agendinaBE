package com.example.agendinaBE.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.agendinaBE.model.AttivitaEntity;


public interface AttivitaRepository extends JpaRepository<AttivitaEntity,Long>{
    	@Query(value="Select * from attivita where id = :id", nativeQuery = true)
	public AttivitaEntity prendiId(@Param("id") Long dipendentiId);
	

}
