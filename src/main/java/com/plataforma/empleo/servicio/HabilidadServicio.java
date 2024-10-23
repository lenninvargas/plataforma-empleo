package com.plataforma.empleo.servicio;

import java.util.List;

import com.plataforma.empleo.entidad.Habilidad;

public interface HabilidadServicio {
	
	public List<Habilidad> ListaHabilidades();
	
	public Habilidad crearHabilidad(Habilidad habilidadNueva);
	

}
