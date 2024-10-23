package com.plataforma.empleo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plataforma.empleo.entidad.Empleador;

@Repository
public interface EmpleadorRepositorio extends JpaRepository<Empleador, Long> {

	Empleador findByCorreo(String correo);

	

}
