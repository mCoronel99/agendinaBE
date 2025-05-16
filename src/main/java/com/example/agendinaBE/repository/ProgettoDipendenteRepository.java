package com.example.agendinaBE.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.agendinaBE.model.ProgettoDipendenteEntity;
import com.example.agendinaBE.model.ProgettoDipendenteKey;

public interface ProgettoDipendenteRepository extends JpaRepository<ProgettoDipendenteEntity, ProgettoDipendenteKey>{
	
}
