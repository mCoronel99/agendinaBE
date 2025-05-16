package com.example.agendinaBE.service.attivita.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.agendinaBE.dto.AttivitaDTO;
import com.example.agendinaBE.model.AttivitaEntity;
import com.example.agendinaBE.model.DipendentiEntity;
import com.example.agendinaBE.model.ProgettoEntity;
import com.example.agendinaBE.model.StatiEntity;
import com.example.agendinaBE.repository.AttivitaRepository;
import com.example.agendinaBE.repository.DipendentiRepository;
import com.example.agendinaBE.repository.ProgettoRepository;
import com.example.agendinaBE.repository.StatiRepository;
import com.example.agendinaBE.service.attivita.IAttivitaService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AttivitaService implements IAttivitaService {

    @Autowired
    private AttivitaRepository attivitaRepository;

    @Autowired
    private ProgettoRepository progettoRepository;

    @Autowired
    private DipendentiRepository dipendentiRepository;

    @Autowired
    private StatiRepository statiRepository;

    @Override
    public List<AttivitaEntity> trovaTutteAttivita() {
        List<AttivitaEntity> Attivita = attivitaRepository.findAll();
        return Attivita;
    }

    @Override
public AttivitaEntity creaAttivita(AttivitaDTO dto) {
    System.out.println(">>> JSON ricevuto:SERVICE");

    DipendentiEntity dipendente = dipendentiRepository.findById(dto.getId_dipendente())
        .orElseThrow(() -> new RuntimeException("Dipendente non trovato"));

    ProgettoEntity progetto = progettoRepository.findById(dto.getId_progetto())
        .orElseThrow(() -> new RuntimeException("Progetto non trovato"));

    StatiEntity stato = statiRepository.findById(dto.getId_stato())
        .orElseThrow(() -> new RuntimeException("Stato non trovato"));

    AttivitaEntity attivita = new AttivitaEntity();
    attivita.setDescrizione(dto.getDescrizione());
    attivita.setData_inizio(dto.getData_inizio());
    attivita.setData_fine(dto.getData_fine());
    attivita.setId_dipendente(dipendente);
    attivita.setId_progetto(progetto);
    attivita.setId_stato(stato);

    return attivitaRepository.save(attivita);
}

@Override
public AttivitaEntity modificaAttivita(AttivitaDTO dto) {
    // Recupera l'entità esistente
    AttivitaEntity attivita = attivitaRepository.prendiId(dto.getId());
    
    // Aggiorna i campi solo se presenti nel DTO
    if (dto.getDescrizione() != null) {
        attivita.setDescrizione(dto.getDescrizione());
    }

    if (dto.getData_inizio() != null) {
        attivita.setData_inizio(dto.getData_inizio());
    }

    attivita.setData_fine(dto.getData_fine());

    // Se è presente un id_progetto, carica l'entità associata e settala
    if (dto.getId_progetto() != null) {
        ProgettoEntity progetto = progettoRepository.findById(dto.getId_progetto())
                .orElseThrow(() -> new RuntimeException("Progetto non trovato"));
        attivita.setId_progetto(progetto);
    }

    if (dto.getId_dipendente() != null) {
        DipendentiEntity dipendente = dipendentiRepository.findById(dto.getId_dipendente())
                .orElseThrow(() -> new RuntimeException("Dipendente non trovato"));
        attivita.setId_dipendente(dipendente);
    }

    if (dto.getId_stato() != null) {
        StatiEntity stato = statiRepository.findById(dto.getId_stato())
                .orElseThrow(() -> new RuntimeException("Stato non trovato"));
        attivita.setId_stato(stato);
    }

    return attivitaRepository.save(attivita);
}


    @Override
    public void eliminaAttivita(Long id) {
        try{
            attivitaRepository.deleteById(id);
        } catch(EmptyResultDataAccessException e){
            throw new EntityNotFoundException("Attivita non trovata" + id);
        }
    }
    
}
