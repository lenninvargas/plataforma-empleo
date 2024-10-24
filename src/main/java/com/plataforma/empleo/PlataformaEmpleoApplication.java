package com.plataforma.empleo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.plataforma.empleo.entidad.Habilidad;
import com.plataforma.empleo.entidad.TipoUsuario;
import com.plataforma.empleo.repositorio.HabilidadRepositorio;
import com.plataforma.empleo.repositorio.TipoUsuarioRepositorio;
import com.plataforma.empleo.servicio.HabilidadServicio;
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
	
	
	@Autowired
	HabilidadRepositorio habilidadRepositorio;
	
	@Autowired
	private HabilidadServicio habilidadServicioImpl;

	@Override
	public void run(String... args) throws Exception {

		if (tipoUsuServicioImpl.obtenerTipoUsuarios().size() < 2) {
			TipoUsuario tipoUsuario1 = new TipoUsuario("Empleado");
			tipoUsuarioRepositorio.save(tipoUsuario1);
			
			TipoUsuario tipoUsuario2 = new TipoUsuario("Empleador");
			tipoUsuarioRepositorio.save(tipoUsuario2);
		}
		
		
		if(habilidadServicioImpl.ListaHabilidades().size() < 10) {
			
			Habilidad habilidad1 = new Habilidad("Carpintero");
			habilidadRepositorio.save(habilidad1);
			
			Habilidad habilidad2 = new Habilidad("Cocinero");
			habilidadRepositorio.save(habilidad2);
			
			Habilidad habilidad3 = new Habilidad("Pintor");
			habilidadRepositorio.save(habilidad3);
			
			Habilidad habilidad4 = new Habilidad("Electricista");
			habilidadRepositorio.save(habilidad4);
			
			Habilidad habilidad5 = new Habilidad("Plomero");
			habilidadRepositorio.save(habilidad5);
			
			Habilidad habilidad6 = new Habilidad("Jardinero");
			habilidadRepositorio.save(habilidad6);
			
			Habilidad habilidad9 = new Habilidad("Albañil");
			habilidadRepositorio.save(habilidad9);	
		}
		
	}
}
