package com.example.agendinaBE.model;


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
@Table(name="utenti")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UtenteEntity {


	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name="username")
	private String username;

    @Column(name="password")
	private String password;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_tipo_utenti", referencedColumnName = "id")
	@JsonIncludeProperties("id")
	private TipoUtenteEntity tipo_utenti;
 }

