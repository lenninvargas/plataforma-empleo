package com.plataforma.empleo.controlador;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.plataforma.empleo.entidad.Empleado;
import com.plataforma.empleo.entidad.Empleador;
import com.plataforma.empleo.entidad.Persona;
import com.plataforma.empleo.entidad.TipoUsuario;
import com.plataforma.empleo.servicio.EmpleadoServicio;
import com.plataforma.empleo.servicio.EmpleadorServicio;
import com.plataforma.empleo.servicio.TipoUsuarioServicio;
import com.plataforma.empleo.servicio.UsuarioServicio;
import com.plataforma.empleo.utils.Utilitarios;

import jakarta.servlet.http.HttpSession;


@Controller
public class RegistroPersonaControlador {

	@Autowired
	private UsuarioServicio usuarioServicio;
	
	@Autowired
	private TipoUsuarioServicio tipoUsuarioServicio;
	
	@Autowired
	private EmpleadoServicio empleadoServicio;
	
	@Autowired
	private EmpleadorServicio empleadorServicio;
	
	
	@GetMapping("/")
	public String login(Model model) {
		
		model.addAttribute("usuario", new Persona());
		
		return "login";
	}
	
	@PostMapping("/login")
	public String loginPost(Persona usuario, Model model, HttpSession session) {
		boolean usuarioValido = usuarioServicio.validarUsuario(usuario, session);
		if(usuarioValido) {
<<<<<<< HEAD
			return "redirect:/empleos";
=======
			return "redirect:/empleos"; //REDIGIR
>>>>>>> origin/Alex
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
	public String crearPersona(@ModelAttribute Persona persona, Model model, @RequestParam("foto") MultipartFile foto) {
		
		
			
		TipoUsuario tipoUsuario = tipoUsuarioServicio.obtenerPorId(persona.getTipoUsuario().getId());
		
		String hashedPassword = Utilitarios.extraerHash(persona.getPassword());
		
		
		if(tipoUsuario.getNombre().equalsIgnoreCase("Empleado")) {
			
			Empleado empleado = new Empleado();
		
			empleado.setIdPersona(persona.getIdPersona());
			empleado.setNombre(persona.getNombre());
			empleado.setApellidos(persona.getApellidos());
			empleado.setDireccion(persona.getDireccion());
			empleado.setDni(persona.getDni());
			empleado.setCelular(persona.getCelular());
			empleado.setCorreo(persona.getCorreo());
			empleado.setPassword(hashedPassword);
			empleado.setFechaNacimiento(persona.getFechaNacimiento());
			empleado.setTipoUsuario(persona.getTipoUsuario());
			empleado.setUrlPerfil(persona.getUrlPerfil());

			empleadoServicio.guardarEmpleado(empleado);
		
			
		}else if(tipoUsuario.getNombre().equalsIgnoreCase("Empleador")) {
			
			Empleador empleador = new Empleador();
			
			empleador.setIdPersona(persona.getIdPersona());
			empleador.setNombre(persona.getNombre());
			empleador.setApellidos(persona.getApellidos());
			empleador.setDireccion(persona.getDireccion());
			empleador.setDni(persona.getDni());
			empleador.setCelular(persona.getCelular());
			empleador.setCorreo(persona.getCorreo());
			empleador.setPassword(hashedPassword);
			empleador.setFechaNacimiento(persona.getFechaNacimiento());
			empleador.setTipoUsuario(persona.getTipoUsuario());
			empleador.setUrlPerfil(persona.getUrlPerfil());
			
			
			empleadorServicio.crearEmpleador(empleador);
			
			
		}
		
		return "redirect:/";
		
	}
	
}
