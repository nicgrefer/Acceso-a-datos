package com.gf.ejer.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gf.ejer.entities.Premios;
import com.gf.ejer.repository.PremiosRepository;

@Service
public class PremiosServicioImple implements GeneralService<Premios> {

	@Autowired
	PremiosRepository premiosRepository;

	@Override
	public List<Premios> findAll() {
		return premiosRepository.findAll();
	}

	@Override
	public void save(Premios object) {
		premiosRepository.save(object);
	}

	@Override
	public Premios find(Long id) {
		Optional<Premios> respuesta = premiosRepository.findById(id);
		Premios premio = null;
		if (respuesta.isPresent()) {
			premio = respuesta.get();
		}
		return premio;
	}

	@Override
	public void delete(Long id) {
		premiosRepository.deleteById(id);
	}

}
