package com.plataforma.empleo.servicio;

import java.util.List;

import com.plataforma.empleo.entidad.Empleo;

public interface EmpleoServicio {
	
	public List<Empleo> getAll();
	
	public void create(Empleo empleo);
	
	public Empleo getById(Integer id);
	
	public List<Empleo> obtenerEmpleosDeEmpleador(Long id);
	
	public List<Empleo> obtenerEmpleos();
}
