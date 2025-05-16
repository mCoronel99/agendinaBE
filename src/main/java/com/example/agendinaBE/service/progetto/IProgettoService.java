package com.example.agendinaBE.service.progetto;

import java.util.List;

import com.example.agendinaBE.model.ProgettoEntity;


public interface IProgettoService{
	List<ProgettoEntity> findAllProgetto();
	ProgettoEntity createProgetto (ProgettoEntity dto);
	ProgettoEntity updateProgetto (ProgettoEntity dto);
	void deleteProgetto(Long id);
}