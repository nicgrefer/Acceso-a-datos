package com.gf.ejer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gf.ejer.entitys.Clinica;
import com.gf.ejer.repository.ClinicaRepository;

@Service
public class ClinicaServiceImple implements GeneralService<Clinica> {

	@Autowired
	ClinicaRepository clinicaRepository;
	@Override
	public List<Clinica> findAll() {
		// TODO Auto-generated method stub
		return clinicaRepository.findAll();
	}

	@Override
	public void save(Clinica t) {
		// TODO Auto-generated method stub
		clinicaRepository.save(t);
	}

	@Override
	public Clinica findById(Long id) {
		// TODO Auto-generated method stub
		Optional<Clinica>result = clinicaRepository.findById(id);
		Clinica clinica = null;
		if (result.isPresent()) {
			clinica = result.get();
		}
		return clinica;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		clinicaRepository.deleteById(id);
	}

	@Override
	public void update(Clinica t) {
	   Optional<Clinica> result = clinicaRepository.findById(t.getId());
	    if (result.isPresent()) {
	        Clinica clinicaExistente = result.get();
	        clinicaExistente.setCif(t.getCif());
	        clinicaExistente.setNombre(t.getNombre());
	        clinicaExistente.setCiudad(t.getCiudad());
	        clinicaRepository.save(clinicaExistente);
	    } else {
	        System.out.println("No se encontró la clínica para actualizar");
	    }
	}
}
