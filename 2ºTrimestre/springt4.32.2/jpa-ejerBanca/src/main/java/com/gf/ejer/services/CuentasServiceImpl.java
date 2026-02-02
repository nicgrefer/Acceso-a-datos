package com.gf.ejer.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gf.ejer.model.Cuentas;
import com.gf.ejer.repository.CuentasRepository;

@Service
public class CuentasServiceImpl implements CuentasServices {

	@Autowired
	private CuentasRepository cuentasRepository;
	
	@Override
	public Cuentas save(Cuentas cue) {
		return cuentasRepository.save(cue);
	}
	
	@Override
	public List<Cuentas> findAll() {
		return cuentasRepository.findAll();
	}
	
	@Override
	public Optional<Cuentas> findById(Long id) {
		return cuentasRepository.findById(id);
	}
	
	@Override
	public void deleteById(Long id) {
		cuentasRepository.deleteById(id);
	}
}
