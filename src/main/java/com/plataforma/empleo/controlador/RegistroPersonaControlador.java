package com.plataforma.empleo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.plataforma.empleo.servicio.UsuarioServicio;
import com.plataforma.empleo.usuarios.dto.UsuarioRegistroDTO;

@Controller
@RequestMapping("/registro")
public class RegistroPersonaControlador {

	@Autowired
	private UsuarioServicio usuarioServicio;
	
	
	@ModelAttribute("persona")
	public UsuarioRegistroDTO retornarNuevoRegistroDTO() {
		return new UsuarioRegistroDTO();
	}
	
	@GetMapping
	public String mostrarFormularioDeRegistro() {
		return "registro";
	}
	
	@PostMapping()
	public String registrarCuentaUsuario(@ModelAttribute("persona") UsuarioRegistroDTO usuarioRegistroDTO) {
		
		usuarioServicio.guardarPersona(usuarioRegistroDTO);
		
		return "redirect:registro?exito";
	}
	
}
