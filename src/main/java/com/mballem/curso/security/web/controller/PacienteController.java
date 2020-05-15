package com.mballem.curso.security.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mballem.curso.security.domain.Paciente;
import com.mballem.curso.security.domain.Usuario;
import com.mballem.curso.security.service.PacienteService;
import com.mballem.curso.security.service.UsuarioService;

@Controller
@RequestMapping("pacientes")
public class PacienteController {

	@Autowired
	private PacienteService service;
	
	@Autowired
	private UsuarioService usuarioService;
	
	// abrir página de dados pessoais do paciente
	@GetMapping("/dados")
	public String cadastrar(Paciente paciente, ModelMap map, @AuthenticationPrincipal User user) {
		paciente = service.buscarPorUsuarioEmail(user.getUsername());
		if (paciente.hasNotId()) {
			paciente.setUsuario(new Usuario(user.getUsername()));
		}
		map.addAttribute("paciente", paciente);
		
		return "paciente/cadastro";
	}
	
	// salvar o form de dados pessoai do paciente com verificação de senha
	@PostMapping("/salvar")
	public String salvar(Paciente paciente, ModelMap map, @AuthenticationPrincipal User user) {
		Usuario u = usuarioService.buscarPorEmail(user.getUsername());
		if (UsuarioService.isSenhaCorreta(paciente.getUsuario().getSenha(), u.getSenha())) {
			paciente.setUsuario(u);
			service.salvar(paciente);
			map.addAttribute("sucesso", "Seus dados foram inseridos com sucesso.");
		} else {
			map.addAttribute("falha", "Sua senha não confere, tente novamente");
		}
		
		return "paciente/cadastro";
	}
}