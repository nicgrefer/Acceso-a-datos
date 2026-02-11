package com.gf.jpa.entitis;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Entity @Table(name = "instalacion") @NoArgsConstructor @AllArgsConstructor
public class Instalacion {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer numero_paneles;
	private String tipo_instal;
	
	@OneToOne
	private Ubicacion ubicacions;
	@OneToMany @JoinColumn(name = "instaladion_id")
	private Set<Paneles>paneles;
}
