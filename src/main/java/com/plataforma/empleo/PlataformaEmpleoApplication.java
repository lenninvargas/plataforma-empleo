package com.plataforma.empleo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.plataforma.empleo.entidad.TipoUsuario;
import com.plataforma.empleo.repositorio.TipoUsuarioRepositorio;
import com.plataforma.empleo.servicio.impl.TipoUsuarioServicioImpl;

@SpringBootApplication
public class PlataformaEmpleoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PlataformaEmpleoApplication.class, args);
	}
	
	@Autowired
	TipoUsuarioRepositorio tipoUsuarioRepositorio;
	
	@Autowired
	private TipoUsuarioServicioImpl tipoUsuServicioImpl;

	@Override
	public void run(String... args) throws Exception {

		if (tipoUsuServicioImpl.obtenerTipoUsuarios().size() < 2) {
			TipoUsuario tipoUsuario1 = new TipoUsuario("Empleado");
			tipoUsuarioRepositorio.save(tipoUsuario1);
			
			TipoUsuario tipoUsuario2 = new TipoUsuario("Empleador");
			tipoUsuarioRepositorio.save(tipoUsuario2);
		}
		
	}
}
