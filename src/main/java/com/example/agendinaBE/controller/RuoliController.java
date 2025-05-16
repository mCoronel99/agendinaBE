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

import com.example.agendinaBE.model.RuoliEntity;
import com.example.agendinaBE.service.ruoli.impl.RuoliService;

@RestController
@RequestMapping("/api/ruoli")
public class RuoliController {

	@Autowired
	private RuoliService ruoliService;

	@GetMapping("/getAll")
	public ResponseEntity<List<RuoliEntity>> getAll() {
		//altre operazioni
		List<RuoliEntity> listaEntity = ruoliService.findAllRuoli();
		//altre opera
		return ResponseEntity.ok(listaEntity);
	}

	@PostMapping("/create")
	public ResponseEntity<RuoliEntity> create(@RequestBody RuoliEntity input) {
		RuoliEntity newRuolo = ruoliService.createRuoli(input);
		return new ResponseEntity<>(newRuolo, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		ruoliService.deleteRuoli(id);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/update")
	public ResponseEntity<RuoliEntity> update(@RequestBody RuoliEntity input) {
		RuoliEntity newRuolo = ruoliService.updateRuoli(input);
		return new ResponseEntity<>(newRuolo, HttpStatus.CREATED);
	}
}