package com.gf.ejer.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "banco")
public class Bancos {
	
	@Id
	private Long id;
	private String cif;
	private String nombre;
	@Column(name = "domicilio fiscar")
	private String domicilioFiscal;
	
	@OneToMany
	private List<Clientes> clientes;
	
	
}
