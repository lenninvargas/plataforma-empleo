package com.plataforma.empleo.controlador;

import java.time.LocalDate;

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
import com.plataforma.empleo.entidad.Empleo;
import com.plataforma.empleo.servicio.EmpleadoServicio;
import com.plataforma.empleo.servicio.EmpleadorServicio;

import com.plataforma.empleo.servicio.EmpleoServicio;
import com.plataforma.empleo.servicio.HabilidadServicio;

import com.plataforma.empleo.utils.Utilitarios;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmpleoController {

	@Autowired
	private EmpleoServicio empleoService;

	@Autowired
	private HabilidadServicio habilidadService;

	@Autowired
	private EmpleadorServicio empleadorServicio;

	@Autowired
	private EmpleadoServicio empleadoServicio;

	// TIPO DE USUARIO 1 -> EMPLEADO
	@GetMapping("/empleos")
	public String getAll(Model model, HttpSession session, @RequestParam(value = "id", defaultValue = "-1") Integer id) {
		
		
		String correoUsuario = (String) session.getAttribute("usuario");
		//Empleado empleado = empleadoServicio.obtenerEmpleadoPorCorreo(correoUsuario);

		if (correoUsuario == null) {
			return "redirect:/";
		}
		

		if (id == -1) {
			model.addAttribute("empleos", empleoService.obtenerEmpleos());
		} else { 
			
			System.out.println("Habilidad id : " + id);
			
			model.addAttribute("empleos", empleoService.obtenerEmpleosPorHabilidad(id));
		}

		Empleado empleado = empleadoServicio.obtenerEmpleadoPorCorreo(correoUsuario);
		
		model.addAttribute("empleado", empleado);
		model.addAttribute("habilidades", habilidadService.ListaHabilidades());
		
		
		return "empleos";
	}

	// TIPO DE USUARIO 2 -> EMPLEADOR
	@GetMapping("/crearEmpleo")
	public String showCreate(Model model, HttpSession session) {
		
		String correoUsuario = (String) session.getAttribute("usuario");

		if (correoUsuario == null) {

			return "redirect:/";
		}

		Empleador empleador = empleadorServicio.obtenerEmpleadorPorCorreo(correoUsuario);

		model.addAttribute("empleos", empleoService.obtenerEmpleosDeEmpleador(empleador.getIdPersona()));
		model.addAttribute("empleador", empleador);
		model.addAttribute("empleo", new Empleo());
		model.addAttribute("habilidades", habilidadService.ListaHabilidades());

		return "crearEmpleo";
	}

	@PostMapping("/empleo")
	public String create(@ModelAttribute Empleo empleo, HttpSession session, @RequestParam("foto") MultipartFile foto) {
		String photo = Utilitarios.guardarImagen(foto);
		LocalDate fechaActual = LocalDate.now();
		String correo = session.getAttribute("usuario").toString();
		Empleador empleador = empleadorServicio.obtenerEmpleadorPorCorreo(correo);
		empleo.setEmpleador(empleador);
		empleo.setFecha(fechaActual);
		empleo.setUrlFotoDetalle(photo);
		empleoService.create(empleo);
		return "redirect:/crearEmpleo";
	}
}
