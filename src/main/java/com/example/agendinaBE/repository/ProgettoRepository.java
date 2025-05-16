package com.example.agendinaBE.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.agendinaBE.model.ProgettoEntity;

public interface ProgettoRepository extends  JpaRepository<ProgettoEntity, Long>{
	
}