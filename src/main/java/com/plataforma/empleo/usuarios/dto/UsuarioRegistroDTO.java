package com.plataforma.empleo.usuarios.dto;



public class UsuarioRegistroDTO {

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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UsuarioRegistroDTO(Long id, String nombre, String apellido, String pais, String direccion, String dni,
			String celular, String correo, String usuario, String password) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.pais = pais;
		this.direccion = direccion;
		this.dni = dni;
		this.celular = celular;
		this.correo = correo;
		this.usuario = usuario;
		this.password = password;
	}
	
	public UsuarioRegistroDTO( String nombre, String apellido, String pais, String direccion, String dni,
			String celular, String correo, String usuario, String password) {
		super();
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.pais = pais;
		this.direccion = direccion;
		this.dni = dni;
		this.celular = celular;
		this.correo = correo;
		this.usuario = usuario;
		this.password = password;
	}
	
	
	public UsuarioRegistroDTO(String correo) {
		
		super();
		this.correo = correo;
		
	}
	
	public UsuarioRegistroDTO() {
		
	}
		
}


