package com.gf.jpa.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.gf.jpa.entitis.*;
import com.gf.jpa.repository.CuentaRepository;
import com.gf.jpa.service.*;

import jakarta.websocket.server.PathParam;


@RestController
public class BancoControler {

    private final CuentaRepository cuentaRepository;

	@Autowired
	private GeneralService<Banco> bancoService;


    BancoControler(CuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

	
	@GetMapping("/bancos")
	public List<Banco>getAll(){
		return bancoService.FindAll();
	}
	
	@GetMapping("/banco/{id}")
	public Banco getById(@PathVariable Long id) {
		return bancoService.findId(id);
	}
	
	@PutMapping("/banco/{id}")
	public void updateBanco (@PathVariable Long id, @RequestBody Banco banco) {
		Banco updateBanco = bancoService.findId(id);
		if (updateBanco != null) {
			bancoService.save(updateBanco);
		}
	}
	
	@PostMapping("/banco")
	public void createBanco(@RequestBody Banco banco) {
		bancoService.save(banco);
	}
	
	@DeleteMapping("/banco/{id}")
	public void deletBanco (@PathVariable Long id, @RequestBody Banco banco) {
		bancoService.delete(id);
	}

}
