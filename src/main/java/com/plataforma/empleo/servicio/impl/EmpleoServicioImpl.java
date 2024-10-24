package com.plataforma.empleo.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plataforma.empleo.entidad.Empleo;
import com.plataforma.empleo.repositorio.EmpleoRepositorio;
import com.plataforma.empleo.servicio.EmpleoServicio;

@Service
public class EmpleoServicioImpl implements EmpleoServicio{

	@Autowired
	private EmpleoRepositorio empleoRepository;
	
	@Override
	public List<Empleo> getAll() {
		return (List<Empleo>)empleoRepository.findAll();
	}

	@Override
	public void create(Empleo empleo) {
		empleoRepository.save(empleo);
	}

	@Override
	public Empleo getById(Integer id) {
		return empleoRepository.findById(id).orElse(null);
	}

	@Override
	public List<Empleo> obtenerEmpleosDeEmpleador(Long id) {
		return empleoRepository.obtenerEmpleosDeEmpleador(id);
	}

	@Override
	public List<Empleo> obtenerEmpleos() {
		return empleoRepository.obtenerEmpleos();
	}

	@Override
	public List<Empleo> obtenerEmpleosPorHabilidad(Integer id) {
		return empleoRepository.obtenerEmpleosPorHabilidad(id);
	}

}
