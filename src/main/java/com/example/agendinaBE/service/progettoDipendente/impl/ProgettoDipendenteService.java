package com.example.agendinaBE.service.progettoDipendente.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.agendinaBE.model.ProgettoDipendenteEntity;
import com.example.agendinaBE.model.ProgettoDipendenteKey;
import com.example.agendinaBE.repository.ProgettoDipendenteRepository;
import com.example.agendinaBE.service.progettoDipendente.IProgettoDipendenteService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProgettoDipendenteService implements IProgettoDipendenteService {

	@Autowired
	private ProgettoDipendenteRepository progettoDipendenteRepository;

	@Override
	public List<ProgettoDipendenteEntity> findAllProgettoDipendente() {
		List<ProgettoDipendenteEntity> progettoDipendente = progettoDipendenteRepository.findAll();

		return progettoDipendente;
	}

	@Override
	public boolean existsById(ProgettoDipendenteKey id) {
		return progettoDipendenteRepository.existsById(id);
	}

	@Override
	public ProgettoDipendenteEntity createProgettoDipendente(ProgettoDipendenteEntity dto) {
		ProgettoDipendenteEntity entitySaved = progettoDipendenteRepository.save(dto);
		return entitySaved;
	}

	@Override
	public ProgettoDipendenteEntity updateProgettoDipendente(ProgettoDipendenteEntity dto) {
		ProgettoDipendenteEntity entitySaved = progettoDipendenteRepository.save(dto);
		return entitySaved;
	}

	@Override
	public void deleteProgettoDipendente(ProgettoDipendenteKey id) {
		try {
			progettoDipendenteRepository.deleteById(id);
		} catch (EmptyResultDataAccessException a) {
			throw new EntityNotFoundException(a);
		}

	}

}