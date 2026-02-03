package com.gf.ejer.services;

import java.util.List;
import java.util.Optional;

import com.gf.ejer.models.Participacion;

public interface ParticipacionServices {

	void save(Participacion parti);
	List<Participacion> findAll(Participacion parti);
	Optional<Participacion> delete(Long id);

}
