package com.gf.ejer.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gf.ejer.model.Clientes;
import com.gf.ejer.repository.ClienteRepository;

@Service
public class ClientesServiceImpl implements ClientesServices {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public Clientes save(Clientes cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	public List<Clientes> findAll() {
		return clienteRepository.findAll();
	}
	
	@Override
	public Optional<Clientes> findById(Long id) {
		return clienteRepository.findById(id);
	}
	
	@Override
	public Clientes update(Long id, Clientes cliente) {
		if (clienteRepository.existsById(id)) {
			cliente.setId(id);
			return clienteRepository.save(cliente);
		}
		return null;
	}
	
	@Override
	public void deleteById(Long id) {
		clienteRepository.deleteById(id);
	}
}
