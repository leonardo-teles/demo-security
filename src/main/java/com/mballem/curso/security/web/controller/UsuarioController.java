package com.mballem.curso.security.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mballem.curso.security.domain.Usuario;
import com.mballem.curso.security.service.UsuarioService;

@Controller
@RequestMapping("u")
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	
	// abrir cadastro de usuários (médico/admin/paciente)
	@GetMapping("/novo/cadastro/usuario")
	public String cadastroPorAdminMedicoPaciente(Usuario usuario) {
		return "usuario/cadastro";
	}
	
	// abrir lista de usuários
	@GetMapping("/lista")
	public String listaUsuarios() {
		return "usuario/lista";
	}
	
	// abrir lista de usuários
	@GetMapping("/datatables/server/usuarios")
	public ResponseEntity<?> listaUsuariosDatatbles(HttpServletRequest request) {
		return ResponseEntity.ok(service.buscarTodos(request));
	}
}
