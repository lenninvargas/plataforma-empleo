package com.plataforma.empleo.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.plataforma.empleo.modelo.Habilidad;

@Repository
public interface HabilidadRepository extends CrudRepository<Habilidad, Integer>{

}