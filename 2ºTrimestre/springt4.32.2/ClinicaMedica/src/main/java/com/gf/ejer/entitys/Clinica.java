package com.gf.ejer.entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Entity @Table(name = "clinica") @NoArgsConstructor @AllArgsConstructor
public class Clinica {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cif;
	private String nombre;
	private String ciudad;
	
}
