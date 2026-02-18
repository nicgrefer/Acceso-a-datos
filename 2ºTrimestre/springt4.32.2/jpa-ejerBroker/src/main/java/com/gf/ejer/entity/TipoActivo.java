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

@Data @Entity @Table(name = "tipo_activo") @NoArgsConstructor @AllArgsConstructor
public class TipoActivo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;
    private double precioCotizacion;
    
    @ManyToOne @JoinColumn(name = "id_mercado")
    private Mercado mercado;
}
