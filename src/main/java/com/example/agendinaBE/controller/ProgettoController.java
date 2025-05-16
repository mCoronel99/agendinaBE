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

import com.example.agendinaBE.model.ProgettoEntity;
import com.example.agendinaBE.service.progetto.impl.ProgettoService;

@RestController
@RequestMapping("/api/progetto")
public class ProgettoController {
	@Autowired
	private ProgettoService progettoService;

	@GetMapping("/getAll")
	public ResponseEntity<List<ProgettoEntity>> getAll() {
		List<ProgettoEntity> listaEntity = progettoService.findAllProgetto();
		return ResponseEntity.ok(listaEntity);
	}

	@PostMapping("/create")
	public ResponseEntity<ProgettoEntity> create(@RequestBody ProgettoEntity input) {
		ProgettoEntity newProgetto = progettoService.createProgetto(input);
		return new ResponseEntity<>(newProgetto, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<ProgettoEntity> update(@RequestBody ProgettoEntity input) {
		ProgettoEntity newProgetto = progettoService.updateProgetto(input);
		return new ResponseEntity<>(newProgetto, HttpStatus.CREATED);
	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		progettoService.deleteProgetto(id);
		return ResponseEntity.ok().build();
	}

}