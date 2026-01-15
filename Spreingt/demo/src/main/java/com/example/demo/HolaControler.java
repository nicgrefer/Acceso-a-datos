package com.example.demo;

import java.security.PublicKey;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HolaControler {
	@GetMapping({"/","/hola"})
	public String mostrarPagina(){
		return "hola";
		
	}
}
