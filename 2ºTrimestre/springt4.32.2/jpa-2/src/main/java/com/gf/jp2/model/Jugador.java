package com.gf.jp2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
// relaccion 1-N (jugador y club)
@Entity
@Table(name = "jugadores")
@Data
@NoArgsConstructor
public class Jugador {
	@Id
	private Long id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "apellidos")
	private String apellido;
	@Column(name = "numero")
	private Integer numero;
	@Column(name = "posicion")
	private String posicion;
}
