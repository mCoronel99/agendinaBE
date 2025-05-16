package com.example.agendinaBE.service.progetto.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.agendinaBE.model.ProgettoEntity;
import com.example.agendinaBE.repository.ProgettoRepository;
import com.example.agendinaBE.service.progetto.IProgettoService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProgettoService implements IProgettoService{

	@Autowired
	private ProgettoRepository progettoRepository;
	@Override
	public List<ProgettoEntity> findAllProgetto() {
		List<ProgettoEntity> progetto =  progettoRepository.findAll();
		
		return progetto;
	}

	@Override
	public ProgettoEntity createProgetto(ProgettoEntity dto) {
		ProgettoEntity entitySaved = progettoRepository.save(dto);
		return entitySaved;
	}

	@Override
	public ProgettoEntity updateProgetto(ProgettoEntity dto) {
		ProgettoEntity entitySaved = progettoRepository.save(dto);
		return entitySaved;
	}

	@Override
	public void deleteProgetto(Long id) {
		try {
			progettoRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EntityNotFoundException(e);
		}
		
	}
	
}