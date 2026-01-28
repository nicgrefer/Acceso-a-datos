package com.gf.jp1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gf.jp1.model.Usuario;
import com.gf.jp1.service.UsuarioService;

@RestController
public class UsuarioController {

	@Autowired
	UsuarioService usuarios;
	
	@GetMapping({"/","usuarios"})
	public List<Usuario> getAll(){
		return (List<Usuario>) usuarios.findAll();
	}
}
