package com.example.agendinaBE.service.settore.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.agendinaBE.model.SettoreEntity;
import com.example.agendinaBE.repository.SettoreRepository;
import com.example.agendinaBE.service.settore.ISettoreService;

import jakarta.persistence.EntityNotFoundException;

@Service
public  class  SettoreService implements ISettoreService{

	@Autowired
	private SettoreRepository settoreRepository;
	
	@Override
	public List<SettoreEntity> findAllSettore() {
		List<SettoreEntity> settore = settoreRepository.findAll();
		return settore;
	}

	@Override
	public SettoreEntity createSettore(SettoreEntity dto) {
		SettoreEntity entitySaved = settoreRepository.save(dto);
		return entitySaved;
	}

	@Override
	public SettoreEntity updateSettore(SettoreEntity dto) {
		SettoreEntity entitySaved = settoreRepository.save(dto);
		return entitySaved;
	}

	@Override
	public void deleteSettore(Long id) {
		try {
			settoreRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new  EntityNotFoundException("Settore non è stato con id " + id);
		}
		
		
	}
	
}