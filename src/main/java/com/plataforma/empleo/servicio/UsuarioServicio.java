package com.plataforma.empleo.servicio;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.plataforma.empleo.entidad.Persona;
import com.plataforma.empleo.usuarios.dto.UsuarioRegistroDTO;

public interface UsuarioServicio extends UserDetailsService {

	public Persona guardarPersona(UsuarioRegistroDTO registroDTO);
	
	
}
