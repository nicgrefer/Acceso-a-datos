package com.gf.ejer.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "participacion")
@NoArgsConstructor
public class Participacion {

	@Id
	private Long id;
	private String valor;
	private LocalDate fecha;

	
}
