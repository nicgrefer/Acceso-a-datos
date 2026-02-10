package com.gf.ejer.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gf.ejer.entities.Modalidad;
import com.gf.ejer.repository.ModalidadRepository;

@Service
public class ModalidadServicesImple implements GeneralService<Modalidad> {

	@Autowired
	ModalidadRepository modalidadRepository;

	@Override
	public List<Modalidad> findAll() {
		return modalidadRepository.findAll();
	}

	@Override
	public void save(Modalidad object) {
		modalidadRepository.save(object);
	}

	@Override
	public Modalidad find(Long id) {
		Optional<Modalidad> respuesta = modalidadRepository.findById(id);
		Modalidad modalidad = null;
		if (respuesta.isPresent()) {
			modalidad = respuesta.get();
		}
		return modalidad;
	}

	@Override
	public void delete(Long id) {
		modalidadRepository.deleteById(id);
	}

}
