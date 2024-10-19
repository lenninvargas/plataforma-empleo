package com.plataforma.empleo.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plataforma.empleo.entidad.Habilidad;
import com.plataforma.empleo.repositorio.HabilidadRepositorio;
import com.plataforma.empleo.servicio.HabilidadServicio;

@Service
public class HabilidadServicioImpl implements HabilidadServicio{

	@Autowired
	private HabilidadRepositorio habilidadRepository;
	
	@Override
	public List<Habilidad> getAll() {
		return (List<Habilidad>)habilidadRepository.findAll();
	}

}
