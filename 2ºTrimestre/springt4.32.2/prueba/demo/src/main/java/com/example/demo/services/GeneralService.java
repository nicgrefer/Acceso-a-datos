package com.example.demo.services;

import java.util.List;


public interface GeneralService <T> {

    List<T>findAll();
    void save(T objet);
    T findById(Long id);
    void delete(Long id);

}
