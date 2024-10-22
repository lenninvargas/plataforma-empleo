package com.plataforma.empleo.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.plataforma.empleo.entidad.Usuario;

import com.plataforma.empleo.repositorio.UsuarioRepositorio;
import com.plataforma.empleo.servicio.UsuarioServicio;
import com.plataforma.empleo.utils.Utilitarios;

import jakarta.servlet.http.HttpSession;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	@Override
	public Usuario crearUsuarioLogin(Usuario usuario, MultipartFile foto) {
		
		String imgFoto = Utilitarios.guardarImagen(foto);
		usuario.setUrlPerfil(imgFoto);
		
		return usuarioRepositorio.save(usuario);
	

	}

	@Override
	public boolean validarUsuario(Usuario usuario, HttpSession session) {

		Usuario usuarioCorreo = usuarioRepositorio.findBycorreo(usuario.getCorreo());

		if (usuarioCorreo == null) {
			return false;
		}

		if (!Utilitarios.verificarContrasenia(usuario.getPassword(), usuarioCorreo.getPassword())) {
			return false;
		}
		
		//VALIDACION EXITOSA!!!
		session.setAttribute("usuario", usuario.getCorreo());
		return true;
	}

	@Override
	public Usuario buscarUsuarioPorCorreo(String correo) {
		return usuarioRepositorio.findBycorreo(correo);
	}

	@Override
	public Usuario buscarPorId(Long id) {
		return usuarioRepositorio.findById(id).get();
	}
}
