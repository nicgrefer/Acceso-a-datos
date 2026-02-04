package com.gf.ejer.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
	
	@ManyToOne
	private List<Sociedad>sociedad;
	@OneToOne
	private List<Lote>lote;
	
}
