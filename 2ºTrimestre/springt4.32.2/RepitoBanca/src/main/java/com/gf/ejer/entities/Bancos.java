package com.gf.ejer.entities;

import java.util.HashSet;
import java.util.Set;

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

@Data @Entity @Table(name = "bancos") @NoArgsConstructor @AllArgsConstructor
public class Bancos {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cif;
	private String nombre;
	private String domicilio_fiscal;
	
	@ManyToOne @JoinColumn(name = "id_cliente")
	private Set<Clientes>clientes = new HashSet<Clientes>();
	
}
