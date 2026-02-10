package com.gf.ejer.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gf.ejer.entities.Participante;
import com.gf.ejer.services.ParticipanteServiceImple;

@RestController
public class ParticipanteController {
	
	@Autowired
	private ParticipanteServiceImple participanteService;

	@GetMapping("/participante")
	public List<Participante> getAll(){
		return participanteService.findAll();
	}
	
	@PostMapping("/participante")
	public void save(@RequestBody Participante participante) {
		participanteService.save(participante);
	}
	
	@GetMapping("/participante/{id}")
	public Participante getById(@PathVariable Long id) {
		return participanteService.find(id);
	}
	
	@DeleteMapping("/participante/{id}")
	public void deleteParticipante(@PathVariable Long id) {
		participanteService.delete(id);
	}

}