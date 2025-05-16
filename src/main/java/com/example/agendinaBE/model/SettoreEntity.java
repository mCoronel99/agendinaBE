package com.example.agendinaBE.model;

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
@Table(name="settore")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SettoreEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_capo", referencedColumnName = "id")
	@JsonIncludeProperties("id")
	private DipendentiEntity id_capo;
	
	@JsonIgnore
	@OneToMany(mappedBy = "id_sett", fetch = FetchType.LAZY)
    private List<ProgettoEntity> progetti;
	
	@Column(name="nome")
	private String nome;
}