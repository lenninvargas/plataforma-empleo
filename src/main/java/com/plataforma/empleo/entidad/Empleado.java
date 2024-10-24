package com.plataforma.empleo.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
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
public class Empleado extends Usuario {

	@ManyToOne(targetEntity = Habilidad.class)
	@JoinColumn(name = "id_habilidad")
	private Habilidad habilidad;
	
	private Double calificacion;
	
}