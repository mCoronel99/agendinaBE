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

import com.example.agendinaBE.model.SettoreEntity;
import com.example.agendinaBE.service.settore.impl.SettoreService;


@RestController
@RequestMapping("/api/settore")
public class SettoreController {
	@Autowired
	private SettoreService settoreService;

	@GetMapping("/getAll")
	public ResponseEntity<List<SettoreEntity>> getAll() {
		List<SettoreEntity> listaEntity = settoreService.findAllSettore();
		return ResponseEntity.ok(listaEntity);
	}

	@PostMapping("/create")
	public ResponseEntity<SettoreEntity> create(@RequestBody SettoreEntity input) {
		SettoreEntity newSettore = settoreService.createSettore(input);
		return new ResponseEntity<>(newSettore, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<SettoreEntity> update(@RequestBody SettoreEntity input) {

		SettoreEntity newSettore = settoreService.updateSettore(input);
		return new ResponseEntity<>(newSettore, HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		settoreService.deleteSettore(id);
		return ResponseEntity.ok().build();
	}
}