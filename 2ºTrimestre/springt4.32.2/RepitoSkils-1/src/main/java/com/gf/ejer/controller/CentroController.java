package com.gf.ejer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gf.ejer.entities.Centro;
import com.gf.ejer.service.CentroServiceImple;

@RestController
public class CentroController {

	@Autowired
	private CentroServiceImple centroService;
	
	@PutMapping("/centro/{id}")
	public void update(@RequestBody Centro centro, @PathVariable Long id) {
		centroService.update(centro);
	}
	
}
