package com.gf.ejer.services;

import java.util.List;
import java.util.Optional;

import com.gf.ejer.models.Socio;

public interface SocioServices {

	void save(Socio s);
	List<Socio> findAll();
	Optional<Socio> findId(Long id);
	Optional<Socio> delete(Long id);
	Optional<Socio> update(Long id);


}
