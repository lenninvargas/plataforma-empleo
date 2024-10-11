package com.plataforma.empleo.entidad;

import java.time.LocalDate;
import java.util.Collection;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_persona")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
	
	
	private String urlPerfil;	
	
}

