package com.gf.ejer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gf.ejer.models.Lote;

public interface LotesRepository extends JpaRepository<Lote, Long> {

}
