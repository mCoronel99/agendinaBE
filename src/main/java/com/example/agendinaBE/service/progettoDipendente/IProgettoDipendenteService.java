package com.example.agendinaBE.service.progettoDipendente;

import java.util.List;


import com.example.agendinaBE.model.ProgettoDipendenteEntity;
import com.example.agendinaBE.model.ProgettoDipendenteKey;


public interface IProgettoDipendenteService{
	List<ProgettoDipendenteEntity> findAllProgettoDipendente();
	ProgettoDipendenteEntity createProgettoDipendente(ProgettoDipendenteEntity dto) ;
	ProgettoDipendenteEntity updateProgettoDipendente( ProgettoDipendenteEntity dto);
	void deleteProgettoDipendente(ProgettoDipendenteKey id);
	boolean existsById(ProgettoDipendenteKey id);
}