package com.plataforma.empleo.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plataforma.empleo.entidad.Empleado;
import com.plataforma.empleo.repositorio.EmpleadoRepositorio;
import com.plataforma.empleo.servicio.EmpleadoServicio;

@Service
public class EmpleadoServicioImpl implements EmpleadoServicio {

	@Autowired
	private EmpleadoRepositorio empleadoRepositorio;
	
	@Override
	public Empleado guardarEmpleado(Empleado empleadoGuardar) {
		return empleadoRepositorio.save(empleadoGuardar);
	}

	@Override
	public Empleado obtenerIdEmpleado(Long id) {
		
		return empleadoRepositorio.findById(id).get();
	}
}
