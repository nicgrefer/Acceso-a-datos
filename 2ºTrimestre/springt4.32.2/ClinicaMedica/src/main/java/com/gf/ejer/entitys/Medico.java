package com.gf.ejer.entitys;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Entity @Table(name = "medico") @NoArgsConstructor @AllArgsConstructor
public class Medico {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int numero_colegiado;
	private String nombre;
	private String especialidad;
	@ManyToOne @JoinColumn(name = "id_clinica")
	private Clinica clinica;

}
