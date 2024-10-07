package com.plataforma.empleo.entidad;

import java.time.LocalDate;
import java.util.Collection;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_persona")
@Inheritance(strategy = InheritanceType.JOINED)
public class Persona {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_persona")
	private Integer idPersona;
	
	private String nombre;
	
	private String apellidos;
	
	private String direccion;
	
	@Column(length = 8)
	private String dni;
	
	@Column(length = 9)
	private String celular;
	

	private String correo;
	

	private String password;
	
	@Temporal(value = TemporalType.DATE)
	private LocalDate fechaNacimiento;
	
	@ManyToOne(targetEntity = TipoUsuario.class)
	@JoinColumn(name = "id_tipo_usuario")
	private TipoUsuario tipoUsuario;
	
	
	public Integer getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public Persona(Integer idPersona, String nombre, String apellidos, String direccion, String dni, String celular,
			String correo, String password, LocalDate fechaNacimiento, TipoUsuario tipoUsuario) {
		super();
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.dni = dni;
		this.celular = celular;
		this.correo = correo;
		this.password = password;
		this.fechaNacimiento = fechaNacimiento;
		this.tipoUsuario = tipoUsuario;
	}

	public Persona(String nombre, String apellidos, String direccion, String dni, String celular, String correo,
			String password, LocalDate fechaNacimiento, TipoUsuario tipoUsuario) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.dni = dni;
		this.celular = celular;
		this.correo = correo;
		this.password = password;
		this.fechaNacimiento = fechaNacimiento;
		this.tipoUsuario = tipoUsuario;
	}

	public Persona() {
		super();
	}
	
	
	
	
}

