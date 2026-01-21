package com.gf.thym;



import java.util.Arrays;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class PersonaController {
	@GetMapping("/lista")
	public String lista(Model modelo) {
	// creamos tres objetos persona para que salga algo luego
		Persona p1 = new Persona("noel", "prieto", 20);
		Persona p2 = new Persona("sergio", "otero", 40);
		Persona p3 = new Persona("juan", "fernandez", 21);
		// creamos lista de personas 
		List<Persona> personas = Arrays.asList(p1,p2,p3);
		// usamos la clase model para añadir al model con addAttribute 
		//que luego se lanzara a través de la plantilla en la vista, en el html primitivo
		modelo.addAttribute("personas",personas);

		return "lista2";

	}

}

