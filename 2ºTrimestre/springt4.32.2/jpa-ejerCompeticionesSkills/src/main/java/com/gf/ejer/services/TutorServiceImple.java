package com.gf.ejer.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gf.ejer.entities.Tutor;
import com.gf.ejer.repository.TutorRepository;

@Service
public class TutorServiceImple implements GeneralService<Tutor> {

	@Autowired
	TutorRepository tutorRepository;

	@Override
	public List<Tutor> findAll() {
		return tutorRepository.findAll();
	}

	@Override
	public void save(Tutor object) {
		tutorRepository.save(object);
	}

	@Override
	public Tutor find(Long id) {
		Optional<Tutor> respuesta = tutorRepository.findById(id);
		Tutor tutor = null;
		if (respuesta.isPresent()) {
			tutor = respuesta.get();
		}
		return tutor;
	}

	@Override
	public void delete(Long id) {
		tutorRepository.deleteById(id);
	}

}
