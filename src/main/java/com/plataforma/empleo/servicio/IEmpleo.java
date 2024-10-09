package com.plataforma.empleo.servicio;

import java.util.List;

import com.plataforma.empleo.modelo.Empleo;

public interface IEmpleo {
	
	public List<Empleo> getAll();
	
	public void create(Empleo empleo);
}
