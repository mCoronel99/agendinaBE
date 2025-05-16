package com.example.agendinaBE.model;

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
@Table(name="stati")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StatiEntity {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Long id;

    @Column(name="stato")
    private String stato;

    @OneToMany(mappedBy = "id_stato", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<AttivitaEntity> Attivita;

}
