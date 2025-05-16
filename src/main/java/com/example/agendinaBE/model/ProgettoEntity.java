package com.example.agendinaBE.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="progetto")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProgettoEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_sett", referencedColumnName = "id")
	@JsonIncludeProperties("id")
	private SettoreEntity id_sett;

	@Column(name="titolo")
	private String titolo;

	@Column(name = "data_inizio")
	private Date data_inizio;
	
	@OneToMany(mappedBy = "id_progetto", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<AttivitaEntity> Attivita;

}