package com.example.agendinaBE.service.attivita;

import java.util.List;

import com.example.agendinaBE.dto.AttivitaDTO;
import com.example.agendinaBE.model.AttivitaEntity;

public interface IAttivitaService {
    
    List<AttivitaEntity> trovaTutteAttivita();
    AttivitaEntity creaAttivita (AttivitaDTO dto);
    AttivitaEntity modificaAttivita(AttivitaDTO dto);
    void eliminaAttivita(Long id);    
}
