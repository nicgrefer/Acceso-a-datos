package com.gf.jpa.service;

import java.util.List;

public interface GeneralService <T> {
	
	List<T> FindAll();
	void save (T objet);
	T findId(Long id);
	void delete (Long id);

}
