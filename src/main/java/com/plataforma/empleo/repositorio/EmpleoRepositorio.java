package com.plataforma.empleo.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.plataforma.empleo.entidad.Empleo;

@Repository
public interface EmpleoRepositorio extends CrudRepository<Empleo, Integer>{

}
