package com.gf.ejer.model;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "prestamos")
public class Prestamos {

	@Id
	private Long id;
	private LocalDate fecha;
	private double cantidad;
	private int interes;
}
