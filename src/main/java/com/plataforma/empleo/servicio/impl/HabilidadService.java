package com.plataforma.empleo.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plataforma.empleo.entidad.Habilidad;
import com.plataforma.empleo.repositorio.HabilidadRepository;
import com.plataforma.empleo.servicio.IHabilidad;

@Service
public class HabilidadService implements IHabilidad{

	@Autowired
	private HabilidadRepository habilidadRepository;
	
	@Override
	public List<Habilidad> getAll() {
		return (List<Habilidad>)habilidadRepository.findAll();
	}

}
