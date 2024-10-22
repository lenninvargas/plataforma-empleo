package com.plataforma.empleo.servicio;

import java.util.List;

import com.plataforma.empleo.entidad.Empleo;

public interface IEmpleo {
	
	public List<Empleo> getAll();
	
	public void create(Empleo empleo);
	
	public Empleo getById(Integer id);
}
