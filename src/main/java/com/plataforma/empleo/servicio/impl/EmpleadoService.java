package com.plataforma.empleo.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plataforma.empleo.entidad.Empleado;
import com.plataforma.empleo.repositorio.EmpleadoRepository;
import com.plataforma.empleo.servicio.IEmpleado;

@Service
public class EmpleadoService implements IEmpleado{
	
	@Autowired
	private EmpleadoRepository empleadoRepository;

	@Override
	public List<Empleado> getAll() {
		return (List<Empleado>)empleadoRepository.findAll();
	}

}
