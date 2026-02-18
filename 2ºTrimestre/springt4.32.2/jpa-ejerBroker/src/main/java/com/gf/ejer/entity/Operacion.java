package com.gf.ejer.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Entity @Table(name = "operacion") @NoArgsConstructor @AllArgsConstructor
public class Operacion {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    
    private String tipo;
    private double limite_tipo_modenda;
    private double limite_perdida_modenda;
    private String moneda;
    private double inversion_moneda;
    private double inversion_uds;
    private Data fecha_operacion;
    private String estado;

    @ManyToMany @JoinTable(name = "id_inversor")
    private Set<Inversor>inversor = new HashSet<Inversor>();


    @OneToOne 
    private Activo activo;
    
}
