package com.gf.ejer.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.gf.ejer.models.Lote;
import com.gf.ejer.repository.LotesRepository;

public class LotesServicesImple implements LotesServices {

	@Autowired 
	private LotesRepository lotes;
	
	@Override
	public Lote save(Lote l) {
		// TODO Auto-generated method stub
		return lotes.save(l);
	}

	@Override
	public Optional<Lote> findId(Long id) {
		// TODO Auto-generated method stub
		return lotes.findById(id);
	}

	@Override
	public List<Lote> findAll(Lote l) {
		// TODO Auto-generated method stub
		return lotes.findAll();
	}

}
