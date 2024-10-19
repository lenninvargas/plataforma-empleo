package com.plataforma.empleo.servicio;



import org.springframework.web.multipart.MultipartFile;

import com.plataforma.empleo.entidad.Usuario;

import jakarta.servlet.http.HttpSession;


public interface UsuarioServicio {
	
	//Agregando foto prueba 1
	Usuario crearUsuarioLogin(Usuario usuario,  MultipartFile foto);
	
	boolean validarUsuario(Usuario usuario, HttpSession session);
	
	Usuario buscarUsuarioPorCorreo(String correo);
	
	
}
