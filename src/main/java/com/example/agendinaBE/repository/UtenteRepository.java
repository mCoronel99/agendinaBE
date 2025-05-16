package com.example.agendinaBE.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.agendinaBE.model.UtenteEntity;

public interface UtenteRepository extends JpaRepository< UtenteEntity,Long>{

    Optional<UtenteEntity> findByUsername(String username);

    
}