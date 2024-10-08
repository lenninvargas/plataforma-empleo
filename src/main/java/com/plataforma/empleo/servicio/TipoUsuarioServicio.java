package com.plataforma.empleo.servicio;

import java.util.List;

import com.plataforma.empleo.entidad.TipoUsuario;

public interface TipoUsuarioServicio {

	
	public List<TipoUsuario> obtenerTipoUsuarios();
	
	public TipoUsuario obtenerPorId(Long id);
	
}
