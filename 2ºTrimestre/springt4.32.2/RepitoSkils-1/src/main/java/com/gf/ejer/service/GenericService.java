package com.gf.ejer.service;

import java.util.List;


public interface GenericService <T> {

	List<T>findAll();
	void add(T objet);
	T findById(Long id);
	void delete(Long id);
//	void update(Long id);
	void update(T objet);
}
