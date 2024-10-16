package com.plataforma.empleo.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.plataforma.empleo.entidad.Empleo;

@Repository
public interface EmpleoRepository extends CrudRepository<Empleo, Integer>{

}
