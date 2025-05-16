package com.example.agendinaBE.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "dipendenti")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DipendentiEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "cognome")
	private String cognome;

	@Column(name = "data_nascita")
	private Date data_nascita;

	@OneToMany(mappedBy = "id_capo", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<SettoreEntity> settori;

	@OneToMany(mappedBy = "id_dipendente", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<AttivitaEntity> Attivita;

}
