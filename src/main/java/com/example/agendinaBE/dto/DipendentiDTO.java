package com.example.agendinaBE.dto;

import java.util.Date;
import java.util.List;

import com.example.agendinaBE.model.SettoreEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DipendentiDTO {
	
private Long id;
private String nome;
private String cognome;
private Date data_nascita;
private List<SettoreEntity> settori;
}