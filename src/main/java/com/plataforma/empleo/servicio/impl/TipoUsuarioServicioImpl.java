package com.plataforma.empleo.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plataforma.empleo.entidad.TipoUsuario;
import com.plataforma.empleo.repositorio.TipoUsuarioRepositorio;
import com.plataforma.empleo.servicio.TipoUsuarioServicio;

@Service
public class TipoUsuarioServicioImpl implements TipoUsuarioServicio {

	
	@Autowired
	private TipoUsuarioRepositorio tipoUsuarioRepositorio;
	
	@Override
	public List<TipoUsuario> obtenerTipoUsuarios() {
		
		return tipoUsuarioRepositorio.findAll();
	}

	@Override
	public TipoUsuario obtenerPorId(Long id) {
		
		return tipoUsuarioRepositorio.findById(id).get();
	}

}
