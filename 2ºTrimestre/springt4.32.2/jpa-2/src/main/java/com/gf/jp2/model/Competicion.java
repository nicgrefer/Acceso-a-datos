package com.gf.jp2.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
// Relaccion N-N (club-competiciones)
@Entity
@Table(name = "competicion")
@Data
@NoArgsConstructor
public class Competicion {
	@Id
	private Long id;
	private String nombre;
	private Integer premio;
	private LocalDate fechaini;
	private LocalDate fechafin;
	
}
