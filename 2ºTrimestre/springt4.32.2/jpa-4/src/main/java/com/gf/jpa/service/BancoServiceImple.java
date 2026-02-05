package com.gf.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gf.jpa.entitis.Banco;
import com.gf.jpa.repository.BancoRepository;

@Service
public class BancoServiceImple implements GeneralService<Banco> {

	@Autowired
	private BancoRepository repository;
	
	@Override
	public List<Banco> FindAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public void save(Banco objet) {
		// TODO Auto-generated method stub
		repository.save(objet);
	}

	@Override
	public Banco findId(Long id) {
		// TODO Auto-generated method stub
		Optional<Banco> result = repository.findById(id);
		Banco objet = null;
		if (result.isPresent()) {
			objet = result.get();
		}
		return objet;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		
	}

}
