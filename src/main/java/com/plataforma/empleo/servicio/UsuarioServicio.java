package com.plataforma.empleo.servicio;



import org.springframework.web.multipart.MultipartFile;

import com.plataforma.empleo.entidad.Persona;

import jakarta.servlet.http.HttpSession;


public interface UsuarioServicio {
	
	//Agregando foto prueba 1
	Persona crearUsuarioLogin(Persona usuario,  MultipartFile foto);
	
	boolean validarUsuario(Persona usuario, HttpSession session);
	
	Persona buscarUsuarioPorCorreo(String correo);
	
	
}
