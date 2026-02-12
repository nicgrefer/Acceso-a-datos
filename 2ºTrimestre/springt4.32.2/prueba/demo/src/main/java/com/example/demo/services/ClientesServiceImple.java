package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entitis.Clientes;
import com.example.demo.repository.ClientesRepository;

@Service
public class ClientesServiceImple implements GeneralService<Clientes> {

    @Autowired
    private ClientesRepository clienrepo;

    @Override
    public List<Clientes> findAll() {
        // TODO Auto-generated method stub
        return clienrepo.findAll();
    }

    @Override
    public void save(Clientes clientes){
        clienrepo.save(clientes);
    }

    @Override
    public Clientes findById(Long id) {
        // TODO Auto-generated method stub
        Optional<Clientes> result=clienrepo.findById(id);
        Clientes objet = null;
        if(result.isPresent()){
            objet = result.get();
        }
        return objet;
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        clienrepo.deleteById(id);
    }



}
