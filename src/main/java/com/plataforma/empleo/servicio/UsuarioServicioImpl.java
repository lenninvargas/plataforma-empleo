package com.plataforma.empleo.servicio;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plataforma.empleo.entidad.Persona;
import com.plataforma.empleo.entidad.Tipo_Usuario;
import com.plataforma.empleo.repositorio.UsuarioRepositorio;
import com.plataforma.empleo.usuarios.dto.UsuarioRegistroDTO;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	@Override
	public Persona guardarPersona(UsuarioRegistroDTO registroDTO) {

		Persona persona = new Persona(registroDTO.getNombre(), registroDTO.getApellido(), registroDTO.getPais(),
				registroDTO.getDireccion(), registroDTO.getDni(), registroDTO.getCelular(), registroDTO.getCorreo(),
				registroDTO.getUsuario(), registroDTO.getPassword(), Arrays.asList(new Tipo_Usuario("ROL_USER")));

		return usuarioRepositorio.save(persona);

	}

}
