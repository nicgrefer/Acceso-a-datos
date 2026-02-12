package com.example.demo.entitis;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @Table(name = "bancos") @NoArgsConstructor @AllArgsConstructor
public class Bancos {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cif;
    private String nombre;
    private String domicilio;
    
    @ManyToMany
    private Set<Clientes>clientes;

}
