package com.plataforma.empleo.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_tipo_usuario")
public class Tipo_Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String nombre;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Tipo_Usuario(Long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	
	public Tipo_Usuario(String nombre) {
		super();
		
		this.nombre = nombre;
	}
	
	public Tipo_Usuario() {
		super();
	}
}