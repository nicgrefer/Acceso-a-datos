package com.gf.ejer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gf.ejer.entitys.Clinica;
import com.gf.ejer.service.GeneralService;

@RestController
public class ClinicaController {

	@Autowired
	private GeneralService<Clinica> clinicaService;
	
	@GetMapping("/clinica")
	public List<Clinica> findAll() {
		return clinicaService.findAll();
	}
	@GetMapping("/clinica/{id}")
	public Clinica findByID(@PathVariable Long id) {
		return clinicaService.findById(id);
	}
	
	@PostMapping("/clinica")
	public void save(@RequestBody Clinica clinica) {
		clinicaService.save(clinica);
	}
	
	@DeleteMapping("/clinica/{id}")
	public void delete(@PathVariable Long id) {
		clinicaService.delete(id);
	}
	@PutMapping("/clinica/{id}")
	public void update(@RequestBody Clinica clinica, @PathVariable Long id) {
		clinicaService.update(clinica);
	}
	
}
