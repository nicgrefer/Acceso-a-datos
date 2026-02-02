package com.gf.ejer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "cuentas")
public class Cuentas {

	@Id
	private Long id;
	private String isbn;
	private double saldo;
}
