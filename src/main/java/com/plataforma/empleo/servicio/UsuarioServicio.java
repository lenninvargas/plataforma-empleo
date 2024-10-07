package com.plataforma.empleo.servicio;



import com.plataforma.empleo.entidad.Persona;

import jakarta.servlet.http.HttpSession;


public interface UsuarioServicio {

	Persona crearUsuarioLogin(Persona usuario);
	
	boolean validarUsuario(Persona usuario, HttpSession session);
	
	Persona buscarUsuarioPorCorreo(String correo);
	
	
}
