package com.gf.ejer.service;

import java.util.List;

public interface GeneralServer <T> {

	List<T>findAll();
	void save(T t);
	T findById(Long id);
	void delete(Long id);
	
}
