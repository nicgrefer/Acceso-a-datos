package com.gf.jpa.entitis;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Entity @Table(name = "ubicacion") @NoArgsConstructor @AllArgsConstructor
public class Ubicacion {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String direccion;
	private String propietario;
	private String contacto;
}
