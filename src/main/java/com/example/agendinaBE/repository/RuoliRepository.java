package com.example.agendinaBE.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.agendinaBE.model.RuoliEntity;

public interface RuoliRepository extends  JpaRepository<RuoliEntity, Long> {
	// qui ci sono tutte le query "standard" già integrate (select *, insert, delete, e update, ecc.)
}