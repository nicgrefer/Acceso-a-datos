package com.gf.ejer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gf.ejer.entities.Centro;
import com.gf.ejer.repository.CentroRepository;

@Service
public class CentroServiceImple implements GenericService<Centro> {

	@Autowired
	private CentroRepository centro;
	
	@Override
	public List<Centro> findAll() {
		// TODO Auto-generated method stub
		return centro.findAll();
	}

	@Override
	public void add(Centro objet) {
		// TODO Auto-generated method stub
		centro.save(objet);
	}

	@Override
	public Centro findById(Long id) {
		// TODO Auto-generated method stub
		Optional<Centro>result = centro.findById(id);
		Centro centro = null;
		if (result.isPresent()) {
			centro = result.get();
		}
		return centro;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		centro.deleteById(id);
	}

	@Override
	public void update(Centro objet) {
		// TODO Auto-generated method stub
		if(centro.existsById(objet.getId())) {
			centro.save(objet);
		}
	}

	
}
