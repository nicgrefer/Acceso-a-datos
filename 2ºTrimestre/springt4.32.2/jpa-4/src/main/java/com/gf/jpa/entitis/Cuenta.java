package com.gf.jpa.entitis;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "cuenta")
@NoArgsConstructor
@AllArgsConstructor
public class Cuenta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String iban;
	private Double saldo;
	
	/**
	 * //BIDIRECCIONAL -> NO ENTRA
	 * @OneToOne
	 * private Clinte cliente;
	 */
	
}
