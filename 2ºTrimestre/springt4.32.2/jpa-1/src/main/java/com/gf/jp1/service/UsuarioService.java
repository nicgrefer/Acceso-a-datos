package com.gf.jp1.service;

import java.util.List;


import com.gf.jp1.model.Usuario;

public interface UsuarioService {
	
	List<Usuario> findAll();
	void save(Usuario usuario);
	Usuario findById(Long id);
	void delete (Long id);

}