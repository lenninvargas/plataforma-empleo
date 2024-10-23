package com.plataforma.empleo.controlador;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.plataforma.empleo.entidad.Empleado;
import com.plataforma.empleo.entidad.Empleador;
import com.plataforma.empleo.entidad.Usuario;
import com.plataforma.empleo.entidad.TipoUsuario;
import com.plataforma.empleo.servicio.EmpleadoServicio;
import com.plataforma.empleo.servicio.EmpleadorServicio;
import com.plataforma.empleo.servicio.HabilidadServicio;
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
	
	@Autowired
	private HabilidadServicio habilidadServicio;
	
	
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
				return "redirect:/crearEmpleo";
			}

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
	public String mostrarFormularioCrearUsuario(Model model, MultipartFile foto) {
			
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
	
	//EDITAR GET EMPLEADO
	@GetMapping("/editar/{id}")
	public String mostrarFormularioEdicionEmpleado(@PathVariable("id") Long id, Model model, HttpSession session) {
	  
		
		//MODEL
		model.addAttribute("habilidades", habilidadServicio.ListaHabilidades());
		
		Usuario sessionUsuario = usuarioServicio.buscarUsuarioPorCorreo(session.getAttribute("usuario").toString());
		
		if(sessionUsuario == null) {
			
			return "redirect:/";
			
		}
	
		
	    Empleado empleado = empleadoServicio.obtenerIdEmpleado(id);
	    
	    if (empleado != null) {
	        model.addAttribute("empleado", empleado);
	        return "editar_empleado";
	    }
	    
	    return "error";
	}	
	
	//EDITAR POST EMPLEADO
	@PostMapping("/editar/{id}")
	public String actualizarEmpleado(@PathVariable("id") Long id, @ModelAttribute Empleado empleado, HttpSession session, MultipartFile foto) {
		
		
		
		Usuario sessionUsuario = usuarioServicio.buscarUsuarioPorCorreo(session.getAttribute("usuario").toString());
		
		if(sessionUsuario == null) {
						
			return "redirect:/";
						
		}
		
		String fotoImgActualizar = Utilitarios.guardarImagen(foto);
		
		
		
		Empleado empleadoExistente = empleadoServicio.obtenerIdEmpleado(id);
		
		
		if(empleadoExistente != null ) {
			
			empleadoExistente.setCalificacion(empleado.getCalificacion());
			empleadoExistente.setHabilidad(empleado.getHabilidad());
			System.out.println("Id de Habilidad : " + empleado.getHabilidad());
			empleadoExistente.setUrlPerfil(fotoImgActualizar);
			
			empleadoServicio.actualizarEmpleado(empleadoExistente);
				
		} 
		
		
		return "redirect:/empleos";
		
	}
	
	//EDITAR GET EMPLEADOR
		@GetMapping("/editarEmpleador/{id}")
		public String mostrarFormularioEdicion(@PathVariable("id") Long id, Model model, HttpSession session) {
		 
			Usuario sessionUsuario = usuarioServicio.buscarUsuarioPorCorreo(session.getAttribute("usuario").toString());
			
			if(sessionUsuario == null) {
				
				return "redirect:/";
				
			}
			
			Empleador empleador = empleadorServicio.obtenerIdEmpleador(id);
			
		   
		    
		    if (empleador != null) {
		    	model.addAttribute("empleador", empleador);
		    	return "editar_empleador";
		    }
		  
		    return "error";
		}	
		
		//EDITAR POST EMPLEADOR
		@PostMapping("/editarEmpleador/{id}")
		public String actualizarEmpleador(@PathVariable("id") Long id, @ModelAttribute Empleador empleador, HttpSession session, MultipartFile foto) {
			
			
			
			Usuario sessionUsuario = usuarioServicio.buscarUsuarioPorCorreo(session.getAttribute("usuario").toString());
			
			if(sessionUsuario == null) {
							
				return "redirect:/";
							
			}
			
			String fotoImgActualizar = Utilitarios.guardarImagen(foto);
			
			
		
			Empleador empleadorExistente = empleadorServicio.obtenerIdEmpleador(id);
			
			if(empleadorExistente != null ) {
				
				empleadorExistente.setUrlPerfil(fotoImgActualizar);
				
				empleadorServicio.actualizarEmpleador(empleadorExistente);
				
			}
				
			return "redirect:/empleo";
			
		}
	
	
	
}