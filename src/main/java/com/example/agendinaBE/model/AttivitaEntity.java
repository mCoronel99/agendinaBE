package com.example.agendinaBE.model;



import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="attivita")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AttivitaEntity {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_progetto", referencedColumnName = "id")
	@JsonIncludeProperties("id")
    private ProgettoEntity id_progetto;

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_dipendente", referencedColumnName = "id")
	@JsonIncludeProperties("id")
    private DipendentiEntity id_dipendente;

    @Column(name="descrizione")
    private String descrizione;

    @Column(name="data_inizio")
    private Date data_inizio;
    
    @Column(name="data_fine", nullable=true)
    private Date data_fine;

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_stato", referencedColumnName = "id")
	@JsonIncludeProperties("id")
    private StatiEntity id_stato;

}
