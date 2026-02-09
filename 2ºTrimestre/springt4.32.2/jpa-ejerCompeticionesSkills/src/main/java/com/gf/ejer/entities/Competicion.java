package com.gf.ejer.entities;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "competicion")
@NoArgsConstructor
@AllArgsConstructor
public class Competicion {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomber;
	private int ano;
	private LocalDate fecha;
	
	@ManyToMany 
	private Set<Centro>centro;
	@OneToMany @JoinColumn(name = "competicion_id")
	private Set<Participante>participantes;
	
}
