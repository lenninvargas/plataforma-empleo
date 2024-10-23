package com.plataforma.empleo.servicio.impl;

import java.util.List;

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
	
	@Override
	public List<Empleado> getAll() {
		return (List<Empleado>)empleadoRepositorio.findAll();
	}

	@Override
	public Empleado obtenerEmpleadoPorCorreo(String correo) {
		return empleadoRepositorio.findByCorreo(correo);
	}

	@Override
	public Empleado actualizarEmpleado(Empleado empleadoActualizar) {
		return empleadoRepositorio.save(empleadoActualizar);
	}
}
