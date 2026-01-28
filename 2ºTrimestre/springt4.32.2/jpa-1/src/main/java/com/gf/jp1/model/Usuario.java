package com.gf.jp1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "usuario") // para indicar que tabla usamos de la base de datos
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

	@Id // PAra decir que es la pk
	private Long id;
	
	@Column (name = "nombre") // si el nombre de la columna no cuincide le decimos cual es
	private String nombre;
	
	@Column (name = "apellidos")
	private String apellido;
	
	@Column (name = "edad")
	private Long edad;
	
}
