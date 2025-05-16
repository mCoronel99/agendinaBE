package com.example.agendinaBE.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.agendinaBE.dto.DipendentiDTO;
import com.example.agendinaBE.model.DipendentiEntity;
import com.example.agendinaBE.service.dipendenti.impl.DipendentiService;

@RestController
@RequestMapping("/api/dipendenti")
public class DipendentiController {

	@Autowired
	private DipendentiService dipendentiService;

	@GetMapping("/getAll")
	public ResponseEntity<List<DipendentiEntity>> getAll() {
		List<DipendentiEntity> listaEntity = dipendentiService.findAllDipendenti();
		return ResponseEntity.ok(listaEntity);
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<DipendentiEntity> getById(@PathVariable Long id) {
		DipendentiEntity entity = dipendentiService.findById(id);
		return ResponseEntity.ok(entity);
	}

	@PostMapping("/create")
	public ResponseEntity<DipendentiEntity> create(@RequestBody DipendentiEntity input) {
		DipendentiEntity newDipendente = dipendentiService.createDipendenti(input);
		return new ResponseEntity<>(newDipendente, HttpStatus.CREATED);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		dipendentiService.deleteDipendenti(id);
	
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/update")
	public ResponseEntity<DipendentiEntity> update(@RequestBody DipendentiDTO input){
		
		DipendentiEntity newDipendente =  dipendentiService.updateDipendenti(input);
		
		return new ResponseEntity<>(newDipendente, HttpStatus.CREATED);
	}

}