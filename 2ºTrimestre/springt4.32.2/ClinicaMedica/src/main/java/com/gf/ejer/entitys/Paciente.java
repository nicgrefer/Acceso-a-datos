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

@Data @Entity @Table(name = "paciente") @NoArgsConstructor @AllArgsConstructor
public class Paciente {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String dni;
	private String nombre;
	private String apellido;
	private int num_telefono;
	@ManyToOne @JoinColumn(name = "id_medico")
	private Medico medico;
}
