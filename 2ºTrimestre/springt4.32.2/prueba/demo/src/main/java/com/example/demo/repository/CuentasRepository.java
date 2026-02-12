package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entitis.Cuentas;

public interface CuentasRepository extends JpaRepository<Cuentas,Long> {

}
