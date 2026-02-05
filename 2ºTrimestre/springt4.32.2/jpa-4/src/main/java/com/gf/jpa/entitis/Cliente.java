package com.gf.jpa.entitis;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String dni;
	private String nombre;
	private String apellidos;
	private String contacto;
	
	// Relacciones de forma UNIDIRECCIONAL
	
	@OneToOne // relaccion 1-1 El propietario es el clienta ya qie si no existe el cliente no puede existir una cuenta
	private Cuenta cuenta;
	
	@OneToMany @JoinColumn(name = "id_prestamos") // FK en la tabla prestamos
	private Set<Prestamo> prestamos = new HashSet<Prestamo>();
	

	/**
	 * 	//BIDIRECCIONAL -> NO ENTRA
	 * @MamyToMany(cascade = {CascadeType.ALL},fetch=FetchType.ALL)
	 * @JoingTable(name="banco_cliente",joinColumns = {@JoingColumn(name="cliente_id")}),inverserJoinColumns = {
	 * 	{@JoinColumn="banco_id"}
	 * }
	 * private Set <Cliente> clientes = new HashSet<Banco>()
	 * @OneToMany(mappedBy = "clientes",cascade = {CascadeType.ALL},orphanRenoval = true)
	 * private Set <Prestamo> prestamo = new HashSet<Prestamo>()
	 * @OneToOne(mappedBy = "clientes",cascade = {CascadeType.ALL},orphanRenoval = true)
	 * private Cuenta cuenta;
	 */
	
}
