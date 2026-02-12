package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entitis.Clientes;
import com.example.demo.repository.ClientesRepository;
import com.example.demo.services.GeneralService;

@RestController
public class ClienteController {

    private ClientesRepository clienrepo;

    ClienteController(ClientesRepository clientesRepository){
        this.clienrepo=clientesRepository;
    }

    @Autowired
    private GeneralService<Clientes> clienteservice;

    @GetMapping("/clientes")
    public List<Clientes> findAll(){
        return clienteservice.findAll();
    }

    @PostMapping("/clientes")
    public void save(@RequestBody Clientes clientes){
        clienteservice.save(clientes);
    }

    @GetMapping("/clientes/{id}")
    public Clientes findById(Long id){
        return clienteservice.findById(id);
    }

    @DeleteMapping("/clientes/{id}")
    public void delete(Long id){
        clienteservice.delete(id);
    }

}
