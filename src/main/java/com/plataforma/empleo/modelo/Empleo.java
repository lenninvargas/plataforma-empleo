package com.plataforma.empleo.modelo;


import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_empleo")
@Getter
@Setter
@ToString
public class Empleo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_empleo;
	
	@ManyToOne(targetEntity = Empleador.class)
	@JoinColumn(name = "id_empleador")
	private Empleador empleador;
	
	@ManyToOne(targetEntity = Habilidad.class)
	@JoinColumn(name = "id_habilidad")
	private Habilidad habilidad;
	
	private String titulo;
	private String descripcion;
	
	@Temporal(TemporalType.DATE)
	private LocalDate fecha;
}
