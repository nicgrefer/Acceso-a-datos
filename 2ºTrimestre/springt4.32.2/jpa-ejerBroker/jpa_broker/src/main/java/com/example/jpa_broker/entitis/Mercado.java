package com.example.jpa_broker.entitis;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Entity @Table(name = "mercado") @NoArgsConstructor @AllArgsConstructor
public class Mercado {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    
    private String pais;
    private Data hora_apertura;
    private Data hora_cierre;
}
