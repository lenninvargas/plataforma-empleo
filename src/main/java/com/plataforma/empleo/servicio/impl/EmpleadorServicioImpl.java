package com.plataforma.empleo.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plataforma.empleo.entidad.Empleador;
import com.plataforma.empleo.repositorio.EmpleadorRepositorio;
import com.plataforma.empleo.servicio.EmpleadorServicio;

@Service
public class EmpleadorServicioImpl implements EmpleadorServicio {

	@Autowired
	private EmpleadorRepositorio empleadorRepositorio;
	
	
	@Override
	public Empleador crearEmpleador(Empleador crearEmpleador) {
		return empleadorRepositorio.save(crearEmpleador);
	}


	@Override
	public Empleador obtenerIdEmpleador(Long id) {
		
		return empleadorRepositorio.findById(id).get();
	}
	
	@Override
	public Empleador obtenerEmpleadorPorCorreo(String correo) {
		return empleadorRepositorio.findByCorreo(correo);
	}
}
