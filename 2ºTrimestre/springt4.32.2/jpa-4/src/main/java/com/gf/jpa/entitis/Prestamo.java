package com.gf.jpa.entitis;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "prestamo")
@NoArgsConstructor
@AllArgsConstructor
public class Prestamo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date fecha;
	private Double cantidad;
	private Double interes;

	/**
	 * //BIDIRECCIONAL -> NO ENTRA
	 * @ManyToOne
	 * @JoinColum(name="id_cliente")
	 * private Cliente cliente;
	 */
}
