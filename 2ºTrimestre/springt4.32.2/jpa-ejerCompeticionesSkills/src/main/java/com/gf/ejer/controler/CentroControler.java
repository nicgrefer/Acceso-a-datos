package com.gf.ejer.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gf.ejer.entities.Centro;
import com.gf.ejer.repository.CentroRepository;
import com.gf.ejer.services.GeneralService;

@RestController
public class CentroControler {
	
	private final CentroRepository centroRepository;
	
	@Autowired
	private GeneralService<Centro> centroService;

	public CentroControler(CentroRepository centroRepository) {
		super();
		this.centroRepository = centroRepository;
	}
	
	@GetMapping("/centro")
	public List<Centro> getAll(@RequestBody Centro centro){
		return centroService.findAll();
	}
	
	@PostMapping("/centro")
	public void save(@RequestBody Centro centro) {
		centroService.save(centro);
	}
	
	@GetMapping("/centro/{id}")
	public Centro getById(@PathVariable Long id) {
		return centroService.find(id);
	}
	
	@DeleteMapping("/centro/{id}")
	public void deleteCentro(@RequestBody Centro centro) {
		centroRepository.delete(centro);
	}

}
