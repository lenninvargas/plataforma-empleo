package com.plataforma.empleo.entidad;

import java.util.Collection;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.JoinTable;

@Entity
@Table(name = "tb_usuarios", uniqueConstraints = @UniqueConstraint(columnNames = "correo"))
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	//Aprender
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
				name= "tb_usuarios_roles",
				joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id"),
				inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	private Collection<Tipo_Usuario> id_tipo_usuario;

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

	public Collection<Tipo_Usuario> getId_tipo_usuario() {
		return id_tipo_usuario;
	}

	public void setId_tipo_usuario(Collection<Tipo_Usuario> id_tipo_usuario) {
		this.id_tipo_usuario = id_tipo_usuario;
	}

	public Persona() {
		super();
	}

	public Persona(Long id, String nombre, String apellido, String pais, String direccion, String dni, String celular,
			String correo, String usuario, String password, Collection<Tipo_Usuario> id_tipo_usuario) {
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
		this.id_tipo_usuario = id_tipo_usuario;
	}

	public Persona(String nombre, String apellido, String pais, String direccion, String dni, String celular,
			String correo, String usuario, String password, Collection<Tipo_Usuario> id_tipo_usuario) {
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
		this.id_tipo_usuario = id_tipo_usuario;
	}

}