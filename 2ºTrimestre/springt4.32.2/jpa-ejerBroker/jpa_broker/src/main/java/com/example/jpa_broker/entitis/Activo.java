package com.example.jpa_broker.entitis;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Entity @Table(name = "activo") @NoArgsConstructor @AllArgsConstructor
public class Activo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double num_inicial;
    private Double num_final;

    @OneToMany
    private TipoActivo tipoActivo;

}
