package com.example.agendinaBE.model;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "progetto_dipendente")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProgettoDipendenteEntity {

	@EmbeddedId
	ProgettoDipendenteKey id;
	
	@ManyToOne
	@MapsId("id_dipendente")
	@JoinColumn(name = "id_dipendente", referencedColumnName = "id")
	@JsonIncludeProperties("id")
	private DipendentiEntity id_dipendente;

	@ManyToOne
	@MapsId("id_progetto")
	@JoinColumn(name = "id_progetto", referencedColumnName = "id")
	@JsonIncludeProperties("id")
	private ProgettoEntity id_progetto;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ruolo", referencedColumnName = "id")
	@JsonIncludeProperties("id")
	private RuoliEntity id_ruolo;

}