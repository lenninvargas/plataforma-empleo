package com.plataforma.empleo.servicio;

import com.plataforma.empleo.entidad.Empleador;

public interface EmpleadorServicio {

	Empleador crearEmpleador(Empleador crearEmpleador);
	
	Empleador obtenerIdEmpleador(Long id);
	
	
}
