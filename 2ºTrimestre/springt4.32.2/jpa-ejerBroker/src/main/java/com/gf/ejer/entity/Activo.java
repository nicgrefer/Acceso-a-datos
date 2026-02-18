package com.gf.ejer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Entity @Table(name = "activo") @NoArgsConstructor @AllArgsConstructor
public class Activo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double numInicial;
    private Double numFinal;
    
    @ManyToOne @JoinColumn(name = "id_tipo")
    private TipoActivo tipoActivo;
    
}
