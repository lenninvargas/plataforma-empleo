package com.plataforma.empleo.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plataforma.empleo.modelo.Empleo;
import com.plataforma.empleo.repositorio.EmpleoRepository;
import com.plataforma.empleo.servicio.IEmpleo;

@Service
public class EmpleoService implements IEmpleo{

	@Autowired
	private EmpleoRepository empleoRepository;
	
	@Override
	public List<Empleo> getAll() {
		return (List<Empleo>)empleoRepository.findAll();
	}

	@Override
	public void create(Empleo empleo) {
		empleoRepository.save(empleo);
	}

}
