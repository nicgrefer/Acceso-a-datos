package com.gf.ejer.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gf.ejer.entities.Participante;
import com.gf.ejer.repository.ParticipanteRepository;

@Service
public class ParticipanteServiceImple implements GeneralService<Participante> {

	@Autowired
	ParticipanteRepository participanteRepository;

	@Override
	public List<Participante> findAll() {
		return participanteRepository.findAll();
	}

	@Override
	public void save(Participante object) {
		participanteRepository.save(object);
	}

	@Override
	public Participante find(Long id) {
		Optional<Participante> respuesta = participanteRepository.findById(id);
		Participante participante = null;
		if (respuesta.isPresent()) {
			participante = respuesta.get();
		}
		return participante;
	}

	@Override
	public void delete(Long id) {
		participanteRepository.deleteById(id);
	}

}
