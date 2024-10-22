package com.plataforma.empleo.controlador;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.plataforma.empleo.entidad.Empleador;
import com.plataforma.empleo.entidad.Empleo;
import com.plataforma.empleo.servicio.EmpleadorServicio;
import com.plataforma.empleo.servicio.IEmpleo;
import com.plataforma.empleo.servicio.IHabilidad;
import com.plataforma.empleo.utils.Utilitarios;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmpleoController {

	@Autowired
	private IEmpleo empleoService;
	
	@Autowired
	private IHabilidad habilidadService;
	
	@Autowired
	private EmpleadorServicio empleadorServicio;
	
	@GetMapping("/empleos")
	public String getAll(Model model, HttpSession session) {
		model.addAttribute("habilidades", habilidadService.getAll());
		model.addAttribute("empleos", empleoService.getAll());
		return "empleos";
	}
	
	@GetMapping("/empleo")
	public String showCreate(Model model, HttpSession session) {
		model.addAttribute("empleo", new Empleo());
		model.addAttribute("habilidades", habilidadService.getAll());
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
		return "redirect:/empleos";
	}
}
