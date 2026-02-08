package com.gf.ejer.entities;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "participante")
@NoArgsConstructor
@AllArgsConstructor
public class Participante {

	@Id @GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String tipo;
	private Double puntuacion;
	
	@ManyToOne
	private Tutor tutor;
	@ManyToOne
	private Modalidad modalidad;
	
	
}
