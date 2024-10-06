package com.plataforma.empleo.entidad;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Empleo {
	
	
	@Id
	private Long id;
	
	private Long id_empleador;
	
	private Long id_habilidad;
	
	private String titulo;
	
	private String descripcion;
	
	private Date fecha;

}