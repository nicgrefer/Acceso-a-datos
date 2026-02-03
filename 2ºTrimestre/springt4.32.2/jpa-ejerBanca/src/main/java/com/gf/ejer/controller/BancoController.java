package com.gf.ejer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gf.ejer.model.Clientes;
import com.gf.ejer.model.Cuentas;
import com.gf.ejer.services.ClientesServices;
import com.gf.ejer.services.CuentasServices;

@RestController
public class BancoController {
	
	@Autowired
	ClientesServices clientes;
	@Autowired
	CuentasServices cuentas;
	
	
@PostMapping("/cliente")
	public void crearClientes(@RequestBody Clientes cli) {
		clientes.save(cli);
	}
	
@PostMapping("/cuenta")
	public void crearCuenta(@RequestBody Cuentas cue) {
		cuentas.save(cue);
	}
	
@GetMapping("/clientes")
	public List<Clientes> getAll(){
		return (List<Clientes>) clientes.findAll();
	}

}
