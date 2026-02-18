package com.gf.ejer.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Participante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;
    private String tipo; // "equipo" o "individual"
    private Double puntuacion;

    @OneToOne
    @JoinColumn(name = "id_tutor")
    private Tutor tutor;

    @ManyToOne
    @JoinColumn(name = "id_modalidad")
    private Modalidad modalidad;
}