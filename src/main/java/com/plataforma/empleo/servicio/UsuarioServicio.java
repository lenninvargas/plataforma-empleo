package com.plataforma.empleo.servicio;

import com.plataforma.empleo.entidad.Persona;
import com.plataforma.empleo.usuarios.dto.UsuarioRegistroDTO;

public interface UsuarioServicio {

	public Persona guardarPersona(UsuarioRegistroDTO registroDTO);
}
