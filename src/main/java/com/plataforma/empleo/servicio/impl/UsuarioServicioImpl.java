package com.plataforma.empleo.servicio.impl;




import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.stereotype.Service;


import com.plataforma.empleo.entidad.Persona;

import com.plataforma.empleo.repositorio.UsuarioRepositorio;
import com.plataforma.empleo.servicio.UsuarioServicio;
import com.plataforma.empleo.utils.Utilitarios;

import jakarta.servlet.http.HttpSession;


@Service
public class UsuarioServicioImpl implements UsuarioServicio {

	
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	
	@Override
	public Persona crearUsuarioLogin(Persona usuario) {
	
		
		return usuarioRepositorio.save(usuario);
		
	}


	@Override
	public boolean validarUsuario(Persona usuario, HttpSession session) {
		
		Persona personaCorreo = usuarioRepositorio.findBycorreo(usuario.getCorreo());
			
			if(personaCorreo == null) {
				
				return false;
			}
			if(!Utilitarios.verificarContrasenia(personaCorreo.getPassword(), personaCorreo.getPassword())) {
				
				return  false;
			}
			
			session.setAttribute("usuario", personaCorreo.getCorreo());
			
			return true;
		}
	
	@Override
	public Persona buscarUsuarioPorCorreo(String correo) {
		
		return usuarioRepositorio.findBycorreo(correo);
	}	
}
