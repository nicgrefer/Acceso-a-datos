package com.gf.ejer.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gf.ejer.entities.Tutor;
import com.gf.ejer.services.TutorServiceImple;

@RestController
public class TutorController {
	
	@Autowired
	private TutorServiceImple tutorService;

	@GetMapping("/tutor")
	public List<Tutor> getAll(){
		return tutorService.findAll();
	}
	
	@PostMapping("/tutor")
	public void save(@RequestBody Tutor tutor) {
		tutorService.save(tutor);
	}
	
	@GetMapping("/tutor/{id}")
	public Tutor getById(@PathVariable Long id) {
		return tutorService.find(id);
	}
	
	@DeleteMapping("/tutor/{id}")
	public void deleteTutor(@PathVariable Long id) {
		tutorService.delete(id);
	}

}