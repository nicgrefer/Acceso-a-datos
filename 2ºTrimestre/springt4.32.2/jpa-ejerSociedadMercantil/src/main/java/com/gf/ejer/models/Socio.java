package com.gf.ejer.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "socio")
@NoArgsConstructor
public class Socio {

	@Id
	private Long id;
	private String nombre;
	private String apellidos;
	private String contacto;
	
}
