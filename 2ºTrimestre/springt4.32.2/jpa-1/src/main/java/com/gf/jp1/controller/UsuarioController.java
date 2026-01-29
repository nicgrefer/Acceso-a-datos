package com.gf.jp1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gf.jp1.model.Usuario;
import com.gf.jp1.service.UsuarioService;

import jakarta.websocket.server.PathParam;

@RestController
public class UsuarioController {

	@Autowired
	UsuarioService usuarios;
	
	@GetMapping({"/","usuarios"})
	public List<Usuario> getAll(){
		return (List<Usuario>) usuarios.findAll();
	}
	
	@PostMapping("/insert")
	public void createUser(@RequestBody Usuario user) {
        usuarios.save(user);
    }
	
	@PutMapping("/update")
	public void updateUser(@RequestBody Usuario user) {
		usuarios.save(user);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteUser(@PathVariable Long id) {
	    usuarios.delete(id);
	}

	
	
}
