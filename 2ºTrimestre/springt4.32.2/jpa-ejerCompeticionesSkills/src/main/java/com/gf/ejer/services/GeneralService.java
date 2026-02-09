package com.gf.ejer.services;

import java.util.List;
import org.springframework.stereotype.Component;

@Component
public interface GeneralService <T> {
	
	List<T>findAll();
	void save(T object);
	T find(Long id);
	void delete(Long id);
	

}
