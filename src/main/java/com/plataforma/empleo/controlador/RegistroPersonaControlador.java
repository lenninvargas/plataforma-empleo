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
import com.plataforma.empleo.entidad.Usuario;
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
		
		model.addAttribute("usuario", new Usuario());
		
		model.addAttribute("tipoUsuarios", tipoUsuarioServicio.obtenerTipoUsuarios());
		
		return "login";
	}
	
	@PostMapping("/login")
	public String loginPost(Usuario usuario, Model model, HttpSession session) {
		
		boolean usuarioValido = usuarioServicio.validarUsuario(usuario, session);
		
		Usuario usuarioTipo = usuarioServicio.buscarUsuarioPorCorreo(session.getAttribute("usuario").toString());
		
		if(usuarioValido) {
			
			if(usuarioTipo.getTipoUsuario().getNombre().equals("Empleado")) {
				
				System.out.println(usuarioTipo.getTipoUsuario().getNombre());
				return "redirect:/empleos";
				
			}else if(usuarioTipo.getTipoUsuario().getNombre().equals("Empleador")) {
				
				System.out.println(usuarioTipo.getTipoUsuario().getNombre());
				
				return "redirect:/empleo";
			}
				
						
				//return "redirect:/crearEmpleo";
			
		}
		
		model.addAttribute("loginInvalido", "No existe el usuario");
		model.addAttribute("usuario", new Usuario());
		
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/registrar")
	public String mostrarFormularioCrearUsuario(Model model) {
			
		model.addAttribute("usuario", new Usuario());
		
		model.addAttribute("tipoUsuarios", tipoUsuarioServicio.obtenerTipoUsuarios());
		
		return "registrar_usuario";
	}
	
	//CHEQUEAR ESTE METODO.
	@PostMapping("/registrar")
	public String crearPersona(@ModelAttribute Usuario usuario, Model model, @RequestParam("foto") MultipartFile foto) {
	    
TipoUsuario tipoUsuario = tipoUsuarioServicio.obtenerPorId(usuario.getTipoUsuario().getId());
		
		String hashedPassword = Utilitarios.extraerHash(usuario.getPassword());
		
		String fotoImg = Utilitarios.guardarImagen(foto);
		
		
		
		if(tipoUsuario.getNombre().equalsIgnoreCase("Empleado")) {
			
			Empleado empleado = new Empleado();
		
			empleado.setIdPersona(usuario.getIdPersona());
			empleado.setNombre(usuario.getNombre());
			empleado.setApellidos(usuario.getApellidos());
			empleado.setDireccion(usuario.getDireccion());
			empleado.setDni(usuario.getDni());
			empleado.setCelular(usuario.getCelular());
			empleado.setCorreo(usuario.getCorreo());
			empleado.setPassword(hashedPassword);
			empleado.setFechaNacimiento(usuario.getFechaNacimiento());
			empleado.setTipoUsuario(usuario.getTipoUsuario());
			empleado.setUrlPerfil(fotoImg);

			empleadoServicio.guardarEmpleado(empleado);
		
			
		}else if(tipoUsuario.getNombre().equalsIgnoreCase("Empleador")) {
			
			Empleador empleador = new Empleador();
			
			empleador.setIdPersona(usuario.getIdPersona());
			empleador.setNombre(usuario.getNombre());
			empleador.setApellidos(usuario.getApellidos());
			empleador.setDireccion(usuario.getDireccion());
			empleador.setDni(usuario.getDni());
			empleador.setCelular(usuario.getCelular());
			empleador.setCorreo(usuario.getCorreo());
			empleador.setPassword(hashedPassword);
			empleador.setFechaNacimiento(usuario.getFechaNacimiento());
			empleador.setTipoUsuario(usuario.getTipoUsuario());
			empleador.setUrlPerfil(fotoImg);
			
			
			empleadorServicio.crearEmpleador(empleador);
			
			
		}
		
		return "redirect:/";
	}

	
}