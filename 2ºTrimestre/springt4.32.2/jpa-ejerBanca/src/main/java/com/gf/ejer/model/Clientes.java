package com.gf.ejer.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "clientes")
public class Clientes {

	@Id
	private Long id;
	private String dni;
	private String nombre;
	private String apellidos;
	private String contacto;
	
	@OneToOne
	private List<Cuentas>cuentas;
	@OneToMany
	private List<Prestamos>prestamos;
	
}
