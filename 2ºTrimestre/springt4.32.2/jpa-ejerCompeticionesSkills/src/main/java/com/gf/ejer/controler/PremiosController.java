package com.gf.ejer.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gf.ejer.entities.Premios;
import com.gf.ejer.services.PremiosServicioImple;

@RestController
public class PremiosController {
	
	@Autowired
	private PremiosServicioImple premiosService;

	@GetMapping("/premios")
	public List<Premios> getAll(){
		return premiosService.findAll();
	}
	
	@PostMapping("/premios")
	public void save(@RequestBody Premios premio) {
		premiosService.save(premio);
	}
	
	@GetMapping("/premios/{id}")
	public Premios getById(@PathVariable Long id) {
		return premiosService.find(id);
	}
	
	@DeleteMapping("/premios/{id}")
	public void deletePremios(@PathVariable Long id) {
		premiosService.delete(id);
	}

}