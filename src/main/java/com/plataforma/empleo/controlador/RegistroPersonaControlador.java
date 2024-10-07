package com.plataforma.empleo.controlador;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.plataforma.empleo.entidad.Persona;
import com.plataforma.empleo.servicio.TipoUsuarioServicio;
import com.plataforma.empleo.servicio.UsuarioServicio;

import jakarta.servlet.http.HttpSession;


@Controller
public class RegistroPersonaControlador {

	@Autowired
	private UsuarioServicio usuarioServicio;
	
	@Autowired
	private TipoUsuarioServicio tipoUsuarioServicio;
	
	
	@GetMapping("/")
	public String login(Model model) {
		
		model.addAttribute("usuario", new Persona());
		
		return "login";
	}
	
	@PostMapping("/login")
	public String loginPost(Persona usuario, Model model, HttpSession session) {
		
		boolean usuarioValido = usuarioServicio.validarUsuario(usuario, session);
		
		if(usuarioValido) {
			
			return "redirect:/menu";
		}
		
		model.addAttribute("loginInvalido", "No existe el usuario");
		model.addAttribute("usuario", new Persona());
		
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	
	
	@GetMapping("/registrar")
	public String mostrarFormularioCrearUsuario(Model model) {
			
		model.addAttribute("usuario", new Persona());
		
		model.addAttribute("tipoUsuarios", tipoUsuarioServicio.obtenerTipoUsuarios());
		
		
		return "registrar_usuario";
		
	}
	
	@PostMapping("/registrar")
	public String crearPersona(@ModelAttribute Persona persona) {
			
	
		usuarioServicio.crearUsuarioLogin(persona);
		
		return "redirect:/";
		
	}
	
}
