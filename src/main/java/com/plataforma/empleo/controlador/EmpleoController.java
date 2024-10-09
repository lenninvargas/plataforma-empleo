package com.plataforma.empleo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.plataforma.empleo.modelo.Empleo;
import com.plataforma.empleo.servicio.IEmpleo;

@Controller
public class EmpleoController {

	@Autowired
	private IEmpleo empleoService;
	
	@GetMapping("/empleos")
	public String getAll(Model model) {
		model.addAttribute("empleos", empleoService.getAll());
		return "empleos";
	}
	
	@GetMapping("/empleo")
	public String create(Empleo empleo) {
		//empleoService.create(empleo);
		return "crearEmpleo";
	}
}
