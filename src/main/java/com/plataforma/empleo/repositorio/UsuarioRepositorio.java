package com.plataforma.empleo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plataforma.empleo.entidad.Persona;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Persona, Long> {

	
	public Persona findByEmail(String email);
}
