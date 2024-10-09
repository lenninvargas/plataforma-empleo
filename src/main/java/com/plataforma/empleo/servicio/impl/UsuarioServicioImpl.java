package com.plataforma.empleo.servicio.impl;




import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
	public Persona crearUsuarioLogin(Persona persona, MultipartFile foto) {
		
		
		String nombreFoto = Utilitarios.guardarImagen(foto);
		
		persona.setUrlPerfil(nombreFoto);
	
		String hashedPassword = Utilitarios.extraerHash(persona.getPassword());
		
		persona.setPassword(hashedPassword); 
		
		return usuarioRepositorio.save(persona);
		
	}


	@Override
	public boolean validarUsuario(Persona usuario, HttpSession session) {
	    
		
	  
	    Persona personaCorreo = usuarioRepositorio.findBycorreo(usuario.getCorreo());
	        
	   
	    if(personaCorreo == null) {
	        return false;
	    }

	   
	    if(!Utilitarios.verificarContrasenia(usuario.getPassword(), personaCorreo.getPassword())) {
	        return false;
	    }
	    
	    
	    session.setAttribute("usuario", personaCorreo.getCorreo());
	    
	    return true;
	}
	
	@Override
	public Persona buscarUsuarioPorCorreo(String correo) {
		
		return usuarioRepositorio.findBycorreo(correo);
	}	
}
