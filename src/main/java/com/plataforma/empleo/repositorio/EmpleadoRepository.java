package com.plataforma.empleo.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.plataforma.empleo.entidad.Empleado;

@Repository
public interface EmpleadoRepository extends CrudRepository<Empleado, Integer>{

}
