package com.gf.ejer.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gf.ejer.entities.Competicion;
import com.gf.ejer.repository.CompeticionRepository;

@Service
public class CompeticionServiceImple implements GeneralService<Competicion> {

	@Autowired
	CompeticionRepository competicionRepository;
	
	@Override
	public List<Competicion> findAll() {
		// TODO Auto-generated method stub
		return competicionRepository.findAll();
	}

	@Override
	public void save(Competicion object) {
		// TODO Auto-generated method stub
		competicionRepository.save(object);
	}

	@Override
	public Competicion find(Long id) {
		// TODO Auto-generated method stub
		Optional<Competicion> respuesta = competicionRepository.findById(id);
		Competicion com = null;
		if (respuesta.isPresent()) {
			com = respuesta.get();
		}
		return com;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		competicionRepository.deleteById(id);
	}

}
