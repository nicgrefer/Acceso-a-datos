package com.gf.jpa.entitis;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bancos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Banco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Para crear automaticamente el id autoencrementado
	private Long id;
	private String cif;
	private String domicilio_fiscal;
	
	@ManyToMany(cascade = {CascadeType.ALL},fetch=FetchType.LAZY) // Carga perezoasa
	private Set<Cliente> bancos = new HashSet<Cliente>();
	
	
	/**
	 * //BIDIRECCIONAL -> NO ENTRA
	 * @MamyToMany(mappedBy = "bancos")
	 * private Set <Cliente> clientes = 
	 */
	
}
