package com.gf.jp2.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // Relacciona la entidad 
@Table(name = "clubes") // Indicar nombre de la tabla
@Data// Para poder usar geter y seter de manera automaticas
@NoArgsConstructor
@AllArgsConstructor
public class Club {
	@Id // Para indicar que es PK en la base de datos 
	private Long id;
	@Column(name = "nombre") // Nombre de la columna en base de datos
	private String nombre;
	
	@OneToOne // Un entrenador solo pude estar en un club
	//En este caso lo ponemos aqui ya que es el "dominante" ya que si no tenemos club no puede ser entrenador
	private Entrenador entrenador;
	@OneToMany
	@JoinColumn(name = "id_club")// Para indicar con que se tiene que relaccionar
	private List<Jugador> jugadores;
	@ManyToMany
	private List<Competicion> competicions;
	
}
