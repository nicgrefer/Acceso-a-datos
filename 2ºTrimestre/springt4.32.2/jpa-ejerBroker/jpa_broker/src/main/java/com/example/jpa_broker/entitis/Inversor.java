package com.example.jpa_broker.entitis;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Entity @Table(name = "inversor") @NoArgsConstructor @AllArgsConstructor
public class Inversor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dni;
    private String nss;
    private String nacionalidad;
    private Double deposito;
    private String pago_banco;
}
