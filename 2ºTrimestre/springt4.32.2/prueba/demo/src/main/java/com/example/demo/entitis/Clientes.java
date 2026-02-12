package com.example.demo.entitis;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Entity @Table(name = "clientes") @NoArgsConstructor @AllArgsConstructor
public class Clientes {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dni;
    private String nombre;
    private String apellidos;
    private String contacto;

    @OneToOne
    private Set<Cuentas>cuentas;

    @OneToMany @JoinColumn(name = "id_prestamos")
    private Set<Prestamos>prestamos;

}
