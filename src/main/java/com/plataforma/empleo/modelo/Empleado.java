package com.plataforma.empleo.modelo;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_empleado")
@Getter
@Setter
@ToString
public class Empleado extends Persona{
	
	@ManyToOne(targetEntity = Habilidad.class)
	private Habilidad habilidad;
	
	@ColumnDefault("0.0")
	private Double calificacion;
}
