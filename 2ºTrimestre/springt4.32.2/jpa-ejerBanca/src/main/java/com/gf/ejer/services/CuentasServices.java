package com.gf.ejer.services;

import java.util.List;
import java.util.Optional;

import com.gf.ejer.model.Cuentas;

public interface CuentasServices {
	Cuentas save(Cuentas cue);
	List<Cuentas> findAll();
	Optional<Cuentas> findById(Long id);
	void deleteById(Long id);
}
