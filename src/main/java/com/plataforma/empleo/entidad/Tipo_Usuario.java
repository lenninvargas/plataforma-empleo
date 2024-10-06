package com.plataforma.empleo.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Tipo_Usuario {
	
	@Id
	private Long id;
	
	private String nombre;
	

}