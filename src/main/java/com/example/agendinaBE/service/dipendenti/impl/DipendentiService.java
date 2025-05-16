package com.example.agendinaBE.service.dipendenti.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.agendinaBE.dto.DipendentiDTO;
import com.example.agendinaBE.model.DipendentiEntity;
import com.example.agendinaBE.repository.DipendentiRepository;
import com.example.agendinaBE.service.dipendenti.IDipendentiService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DipendentiService implements IDipendentiService {

	@Autowired
	private DipendentiRepository dipendentiRepository;

	@Override
	public List<DipendentiEntity> findAllDipendenti() {
		List<DipendentiEntity> dipendenti = dipendentiRepository.findAll();

		return dipendenti;
	}
	
	@Override
	public DipendentiEntity findById(Long id) {
		return  dipendentiRepository.prendiId(id);
	}

	@Override
	public DipendentiEntity createDipendenti(DipendentiEntity dto) {

		DipendentiEntity entitySaved = dipendentiRepository.save(dto);
		return entitySaved;
	}

	@Override
	public DipendentiEntity updateDipendenti(DipendentiDTO dto) {
		DipendentiEntity dipe = dipendentiRepository.prendiId(dto.getId());
		if(dto.getCognome() != null) {
		dipe.setCognome(dto.getCognome());
		}
		if(dto.getData_nascita() != null) {
		dipe.setData_nascita(dto.getData_nascita());
		} //trovare modo per fare in modo che quando modifichi solo un campo il resto non diventi null
		
		if (dto.getNome() != null) {
		dipe.setNome(dto.getNome());
		}
		DipendentiEntity entitySaved = dipendentiRepository.save(dipe);
		
		return entitySaved;
	}

	@Override
	public void deleteDipendenti(Long id) {
		try {
			dipendentiRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EntityNotFoundException("Dipendenti non è stato trovato con id " + id);
		}

	}

}