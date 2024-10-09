package com.plataforma.empleo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.plataforma.empleo.servicio.IEmpleado;

@Controller
public class ListaEmpleadosController {
	
	@Autowired
	private IEmpleado empleadoService;
	
	@GetMapping("/empleados")
	 public String getAll(Model model) {
		
		model.addAttribute("empleados", empleadoService.getAll());
	  return "listaEmpleados";
	 }
}
