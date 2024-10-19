package com.plataforma.empleo.controlador;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.plataforma.empleo.entidad.Empleador;
import com.plataforma.empleo.entidad.Empleo;
import com.plataforma.empleo.servicio.EmpleadorServicio;
import com.plataforma.empleo.servicio.EmpleoServicio;
import com.plataforma.empleo.servicio.HabilidadServicio;



import jakarta.servlet.http.HttpSession;

@Controller
public class EmpleoController {

	@Autowired
	private EmpleoServicio empleoService;
	
	@Autowired
	private HabilidadServicio habilidadService;
	
	@Autowired
	private EmpleadorServicio empleadorServicio;
	
	
	@GetMapping("/empleos")
	public String getAll(Model model, HttpSession session) {
		model.addAttribute("empleos", empleoService.getAll());
		return "empleos";
	}
	
	@GetMapping("/empleo")
	public String showCreate(Model model, HttpSession session) {
		
		Empleador empleador = empleadorServicio.obtenerEmpleadorPorCorreo(session.getAttribute("usuario").toString());
			
		model.addAttribute("empleo", new Empleo());
		
		model.addAttribute("habilidades", habilidadService.getAll());
		
		model.addAttribute("foto", empleador.getUrlPerfil());
		
		return "crearEmpleo";
	}
	
	@PostMapping("/empleo")
	public String create(@ModelAttribute Empleo empleo, HttpSession session) {
		LocalDate fechaActual = LocalDate.now();
		String correo = session.getAttribute("usuario").toString();
		Empleador empleador = empleadorServicio.obtenerEmpleadorPorCorreo(correo);
		empleo.setEmpleador(empleador);
		empleo.setFecha(fechaActual);
		
		empleoService.create(empleo);
		return "redirect:/empleos";
	}
}
