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

import com.example.agendinaBE.dto.ProgettoDipendenteDTO;
import com.example.agendinaBE.model.DipendentiEntity;
import com.example.agendinaBE.model.ProgettoDipendenteEntity;
import com.example.agendinaBE.model.ProgettoDipendenteKey;
import com.example.agendinaBE.model.ProgettoEntity;
import com.example.agendinaBE.model.RuoliEntity;
import com.example.agendinaBE.service.progettoDipendente.impl.ProgettoDipendenteService;

@RestController
@RequestMapping("/api/progettoDipendente")
public class ProgettoDipendenteController {
	@Autowired
	private ProgettoDipendenteService progettoDipendenteService;

	@GetMapping("/getAll")
	public ResponseEntity<List<ProgettoDipendenteEntity>> getAll() {
		List<ProgettoDipendenteEntity> listaEntity = progettoDipendenteService.findAllProgettoDipendente();
		return ResponseEntity.ok(listaEntity);
	}

	@PostMapping("/create")
public ResponseEntity<?> create(@RequestBody ProgettoDipendenteDTO input) {
    ProgettoEntity pr = new ProgettoEntity();
    pr.setId(input.getIdProgetto());

    DipendentiEntity dip = new DipendentiEntity();
    dip.setId(input.getIdDipendente());

    RuoliEntity ruolo = new RuoliEntity();
    ruolo.setId(input.getIdRuolo());

    ProgettoDipendenteKey id = new ProgettoDipendenteKey(pr, dip);

    // Verifica se esiste già
    boolean exists = progettoDipendenteService.existsById(id);

    if (exists) {
        return ResponseEntity
            .status(HttpStatus.CONFLICT) // 409 Conflict
            .body("ProgettoDipendente già esistente!");
    }

    // Se non esiste, allora creo
    ProgettoDipendenteEntity tmpProgettoDipendente = new ProgettoDipendenteEntity();
    tmpProgettoDipendente.setId(id);
    tmpProgettoDipendente.setId_progetto(pr);
    tmpProgettoDipendente.setId_dipendente(dip);
    tmpProgettoDipendente.setId_ruolo(ruolo);

    ProgettoDipendenteEntity newProgettoDipendente = progettoDipendenteService.createProgettoDipendente(tmpProgettoDipendente);
    return new ResponseEntity<>(newProgettoDipendente, HttpStatus.CREATED);
}


	@DeleteMapping("/delete/{idProgetto}/{idDipendente}")
	public ResponseEntity<Void> delete(@PathVariable Long idProgetto, @PathVariable Long idDipendente) {
		ProgettoEntity pr = new ProgettoEntity();
		pr.setId(idProgetto);

		DipendentiEntity dip = new DipendentiEntity();
		dip.setId(idDipendente);

		ProgettoDipendenteKey id = new ProgettoDipendenteKey(pr, dip);
		progettoDipendenteService.deleteProgettoDipendente(id);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/update")
	public ResponseEntity<ProgettoDipendenteEntity> update(@RequestBody ProgettoDipendenteDTO input) {
		ProgettoEntity pr = new ProgettoEntity();
		pr.setId(input.getIdProgetto());

		DipendentiEntity dip = new DipendentiEntity();
		dip.setId(input.getIdDipendente());

		RuoliEntity ruolo = new RuoliEntity();
		ruolo.setId(input.getIdRuolo());

		ProgettoDipendenteEntity tmpProgettoDipendente = new ProgettoDipendenteEntity();
		
		ProgettoDipendenteKey id = new ProgettoDipendenteKey(pr, dip);
		
		tmpProgettoDipendente.setId(id);
		tmpProgettoDipendente.setId_progetto(pr);
		tmpProgettoDipendente.setId_dipendente(dip);
		tmpProgettoDipendente.setId_ruolo(ruolo);
		
		ProgettoDipendenteEntity newProgettoDipendente = progettoDipendenteService.updateProgettoDipendente(tmpProgettoDipendente);
		return new ResponseEntity<>(newProgettoDipendente, HttpStatus.CREATED);
	}

}