package com.plataforma.empleo.servicio;

import java.util.List;

import com.plataforma.empleo.entidad.Empleado;

public interface EmpleadoServicio {
	
	Empleado guardarEmpleado(Empleado empleadoGuardar);
	Empleado obtenerIdEmpleado(Long id);
	public List<Empleado> getAll();
}
