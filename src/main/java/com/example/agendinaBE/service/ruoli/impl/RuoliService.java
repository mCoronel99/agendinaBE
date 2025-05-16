package com.example.agendinaBE.service.ruoli.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.agendinaBE.model.RuoliEntity;
import com.example.agendinaBE.repository.RuoliRepository;
import com.example.agendinaBE.service.ruoli.IRuoliService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class RuoliService implements IRuoliService{
	@Autowired
	RuoliRepository ruoliRepository;
	
	@Override
	public List<RuoliEntity> findAllRuoli() {
		//altre operazioni
		List<RuoliEntity> ruoli = ruoliRepository.findAll();
		// altre operazioni
		return ruoli;
	}

	@Override
	public RuoliEntity createRuoli(RuoliEntity dto) {
		RuoliEntity entitySaved = ruoliRepository.save(dto);
		return entitySaved;
	}

	@Override
	public RuoliEntity updateRuoli(RuoliEntity dto) {
		RuoliEntity entitySaved = ruoliRepository.save(dto);
		return entitySaved;
	}

	@Override
	public void deleteRuoli(Long id) {
		try {
			ruoliRepository.deleteById(id);
			
		} catch  ( EmptyResultDataAccessException m) {
			throw new EntityNotFoundException("Ruolo non è stato trovato con id " + id);
		}
		
	}
	
}