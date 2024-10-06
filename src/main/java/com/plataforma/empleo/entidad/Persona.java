package com.plataforma.empleo.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Persona {
	
	@Id
	private Long id;
	
	private String nombre;
	
	private String apellido;
	
	private String pais;
	
	private String direccion;
	
	private String dni;
	
	private String celular;
	
	private String correo;
	
	private String usuario;
	
	private String password;
	
	private String id_tipo_usuario;

}