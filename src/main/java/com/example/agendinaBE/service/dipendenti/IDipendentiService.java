package com.example.agendinaBE.service.dipendenti;

import java.util.List;

import com.example.agendinaBE.dto.DipendentiDTO;
import com.example.agendinaBE.model.DipendentiEntity;


public interface IDipendentiService{
	List<DipendentiEntity> findAllDipendenti();
	DipendentiEntity findById(Long id);
	DipendentiEntity createDipendenti(DipendentiEntity dto);
	DipendentiEntity updateDipendenti (DipendentiDTO  dto);
	void  deleteDipendenti (Long id);
}