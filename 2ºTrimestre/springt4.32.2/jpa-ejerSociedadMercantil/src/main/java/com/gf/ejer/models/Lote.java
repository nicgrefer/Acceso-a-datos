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
@Table(name = "lote")
@NoArgsConstructor
public class Lote {
	
	@Id
	private Long id;
	private int totalParticipantes;
	private double porcentageCapital;
	@OneToMany
	private List<Participacion>participacion;

}
