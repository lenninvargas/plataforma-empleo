package com.plataforma.empleo.servicio;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import com.plataforma.empleo.entidad.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
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
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Persona persona = usuarioRepositorio.findByEmail(username);
			if(persona == null) {
				throw new UsernameNotFoundException("Usuario o password invalidos");
			}
			
			return new User(persona.getCorreo(), persona.getPassword(), mapearAutoridadesRoles(persona.getId_tipo_usuario()));
	}
	
	private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Tipo_Usuario> roles){
		
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());
	}
}
