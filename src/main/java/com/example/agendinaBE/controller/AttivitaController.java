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

import com.example.agendinaBE.dto.AttivitaDTO;
import com.example.agendinaBE.model.AttivitaEntity;
import com.example.agendinaBE.service.attivita.impl.AttivitaService;



@RestController
@RequestMapping("/api/attivita")
public class AttivitaController {

    @Autowired
    AttivitaService AttivitaService;

    @GetMapping("/getAll")
    public ResponseEntity<List<AttivitaEntity>> getAll(){
        List<AttivitaEntity> listaEntity = AttivitaService.trovaTutteAttivita();
        return ResponseEntity.ok(listaEntity);
    }

    @PostMapping("/create")
    public ResponseEntity<AttivitaEntity> create(@RequestBody AttivitaDTO input){
        
        System.out.println(">>> JSON ricevuto:"+ input.toString());
        System.out.println("Data inizio: " + input.getData_inizio());
        System.out.println("Descrizione: " + input.getDescrizione());
         AttivitaEntity newAttivita = AttivitaService.creaAttivita(input); 
        System.out.println("DATA INIZIO: " + newAttivita.getData_inizio());
        return new ResponseEntity<>(newAttivita, HttpStatus.CREATED);
        }

    @PutMapping("/update")
    public ResponseEntity<AttivitaEntity> update(@RequestBody AttivitaDTO input){
        
        AttivitaEntity newAttivita = AttivitaService.modificaAttivita(input);
        return new ResponseEntity<>(newAttivita, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        AttivitaService.eliminaAttivita(id);
        return ResponseEntity.ok().build();

    }

    
}
