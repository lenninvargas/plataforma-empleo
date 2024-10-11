package com.plataforma.empleo.controlador;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.plataforma.empleo.modelo.Empleo;
import com.plataforma.empleo.servicio.IEmpleo;
import com.plataforma.empleo.servicio.IHabilidad;

@Controller
public class EmpleoController {

	@Autowired
	private IEmpleo empleoService;
	
	@Autowired
	private IHabilidad habilidadService;
	
	@GetMapping("/empleos")
	public String getAll(Model model) {
		model.addAttribute("empleos", empleoService.getAll());
		return "empleos";
	}
	
	@GetMapping("/empleo")
	public String showCreate(Model model) {
		model.addAttribute("empleo", new Empleo());
		model.addAttribute("habilidades", habilidadService.getAll());
		return "crearEmpleo";
	}
	
	@PostMapping("/empleo")
	public String create(@ModelAttribute Empleo empleo) {
		System.out.println(empleo.getHabilidad().getHabilidad());
		System.out.println(empleo.getTitulo());
		System.out.println(empleo.getDescripcion());
		LocalDate fechaActual = LocalDate.now();
		empleo.setFecha(fechaActual);
		System.out.println(empleo.getFecha());
		empleoService.create(empleo);
		return "crearEmpleo";
	}
}
