package com.gf.ejer.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gf.ejer.entities.Centro;
import com.gf.ejer.repository.CentroRepository;

@Service
public class CentroServiceImple implements GeneralService<Centro> {

	@Autowired
	CentroRepository centro;

	@Override
	public List<Centro> findAll() {
		// TODO Auto-generated method stub
		return centro.findAll();
	}

	@Override
	public void save(Centro object) {
		// TODO Auto-generated method stub
		centro.save(object);		
	}

	@Override
	public Centro find(Long id) {
		// TODO Auto-generated method stub
		Optional<Centro> result = centro.findById(id);
		Centro objet = null;
		if (result.isPresent()) {
			objet = result.get();
		}
		return objet;
	}

	@Override
	public void delete(Long id) {
		centro.deleteById(id);
	}

}
