package com.plataforma.empleo.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_empleado")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Empleado extends Persona {

	@ManyToOne(targetEntity = Habilidad.class)
	private Long id_habilidad;
	
	private Double calificacion;
	
}