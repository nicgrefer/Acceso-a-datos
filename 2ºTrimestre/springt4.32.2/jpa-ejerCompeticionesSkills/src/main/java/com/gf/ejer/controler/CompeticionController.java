package com.gf.ejer.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gf.ejer.entities.Competicion;
import com.gf.ejer.services.CompeticionServiceImple;

@RestController
public class CompeticionController {
	
	@Autowired
	private CompeticionServiceImple competicionService;

	@GetMapping("/competicion")
	public List<Competicion> getAll(){
		return competicionService.findAll();
	}
	
	@PostMapping("/competicion")
	public void save(@RequestBody Competicion competicion) {
		competicionService.save(competicion);
	}
	
	@GetMapping("/competicion/{id}")
	public Competicion getById(@PathVariable Long id) {
		return competicionService.find(id);
	}
	
	@DeleteMapping("/competicion/{id}")
	public void deleteCompeticion(@PathVariable Long id) {
		competicionService.delete(id);
	}

}