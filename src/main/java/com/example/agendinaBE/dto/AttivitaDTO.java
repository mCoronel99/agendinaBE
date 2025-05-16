package com.example.agendinaBE.dto;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AttivitaDTO {
    private Long id;
    private Long id_progetto;
    private Long id_dipendente;
    private String descrizione;
    private Date data_inizio;
    private Date data_fine;
    private Long id_stato;
}
