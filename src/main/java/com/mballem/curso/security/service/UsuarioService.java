package com.mballem.curso.security.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.mballem.curso.security.domain.Usuario;
import com.mballem.curso.security.repository.UsuarioRepository;

public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	public Usuario buscarPorEmail(String email) {
		return repository.findByEmail(email);
	}
}
