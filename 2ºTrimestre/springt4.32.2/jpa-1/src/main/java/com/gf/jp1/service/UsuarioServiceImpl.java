package com.gf.jp1.service;

import java.awt.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gf.jp1.model.Usuario;
import com.gf.jp1.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepositoty;
	
	@Override
	public java.util.List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return usuarioRepositoty.findAll();
	}

	@Override
	public void save(Usuario usuario) {
		// TODO Auto-generated method stub
		usuarioRepositoty.save(usuario);
		
	}

	@Override
	public Usuario findById(Long id) {
		// TODO Auto-generated method stub
		Optional<Usuario> userResult = usuarioRepositoty.findById(id);
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		usuarioRepositoty.deleteById(id);
		
	}
	

}
