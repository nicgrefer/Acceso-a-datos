package com.gf.ejer.services;

import java.util.List;
import java.util.Optional;

import com.gf.ejer.model.Clientes;

public interface ClientesServices {
	Clientes save(Clientes cli);
	List<Clientes> findAll();
	Optional<Clientes> findById(Long id);
	Clientes update(Long id, Clientes cliente);
	void deleteById(Long id);
}
