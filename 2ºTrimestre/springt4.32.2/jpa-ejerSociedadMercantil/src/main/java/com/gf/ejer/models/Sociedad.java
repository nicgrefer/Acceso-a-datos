package com.gf.ejer.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "sociedad")
@NoArgsConstructor
public class Sociedad {

	@Id
	private Long id;
	private String cif;
	private String nombre;
	private String tipo;
	private String capital;
	
	@OneToMany// 1 sociedad- N socios 
	private List<Socio> socios;
	
}
