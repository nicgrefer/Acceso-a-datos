package com.gf.ejer.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gf.ejer.entities.Modalidad;
import com.gf.ejer.services.ModalidadServicesImple;

@RestController
public class ModalidadController {
	
	@Autowired
	private ModalidadServicesImple modalidadService;

	@GetMapping("/modalidad")
	public List<Modalidad> getAll(){
		return modalidadService.findAll();
	}
	
	@PostMapping("/modalidad")
	public void save(@RequestBody Modalidad modalidad) {
		modalidadService.save(modalidad);
	}
	
	@GetMapping("/modalidad/{id}")
	public Modalidad getById(@PathVariable Long id) {
		return modalidadService.find(id);
	}
	
	@DeleteMapping("/modalidad/{id}")
	public void deleteModalidad(@PathVariable Long id) {
		modalidadService.delete(id);
	}

}