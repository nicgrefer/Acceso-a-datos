package com.gf.ejer.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gf.ejer.models.Lote;
import com.gf.ejer.models.Participacion;
import com.gf.ejer.models.Sociedad;
import com.gf.ejer.models.Socio;
import com.gf.ejer.services.LotesServices;
import com.gf.ejer.services.ParticipacionServices;
import com.gf.ejer.services.SociedadServices;
import com.gf.ejer.services.SocioServices;

import jakarta.websocket.server.PathParam;

@RestController
public class ControllerSM {
	
	@Autowired
	SocioServices socioServices;
	@Autowired
	SociedadServices sociedadServices;
	@Autowired
	LotesServices lotesServices;
	@Autowired
	ParticipacionServices participacionServices;
	
	@PostMapping("/sociedad")
	public void crearSociedad(@RequestBody Sociedad sd ) {
		sociedadServices.save(sd);
	}
	
	@PostMapping("/socio")
	public void crearSocio(@RequestBody Socio s ) {
		socioServices.save(s);
	}
	
	@PostMapping("/lote")
	public void crearLote(@RequestBody Lote l) {
		lotesServices.save(l);
	}
	
	@PostMapping("/participacion")
	public void crearParti(@RequestBody Participacion parti) {
		participacionServices.save(parti);
	}

	@GetMapping("/socios")
	public List<Socio> buscarSocios() {
		return (List<Socio>)socioServices.findAll();
	}
	
	@GetMapping("/socios/{id}")
	public Optional<Socio> buscarSociosId(@PathVariable Long id) {
		return socioServices.findId(id);
	}
	
	@DeleteMapping("/socios/{id}")
	public Optional<Socio> borrarSociosExiste(@PathVariable Long id) {
		return socioServices.delete(id);
	}
	
	@PutMapping("/socios/{id}")
	public Optional<Socio> actualizarSocio(@PathVariable Long id) {
		return socioServices.update(id);
	}
	
	@GetMapping("/lote/{id}")
	public Optional<Lote> buscarLoteId(@PathVariable Long id){
		return lotesServices.findId(id);
	}
	
	@GetMapping("/lotes")
	public List<Lote> buscarLote(){
		return (List<Lote>)lotesServices.findAll();
	}
	
	@GetMapping("/participaciones")
	public List<Participacion> buscarParti(@RequestBody Participacion parti){
		return (List<Participacion>)participacionServices.findAll(parti);
	}

	@DeleteMapping("/participacion{id}")
	public Optional<Participacion> borrarParti(@PathVariable Long id){
		return participacionServices.delete(id);
	}
	
}