package com.example.agendinaBE.model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProgettoDipendenteKey implements Serializable {

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_progetto", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
	ProgettoEntity id_progetto;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_dipendente", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
	DipendentiEntity id_dipendente;

}