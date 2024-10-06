package com.plataforma.empleo.entidad;

import java.math.BigDecimal;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Empleado {

	@Id
	private Long id_persona;
	
	private Long id_habilidad;
	
	private BigDecimal calificacion;
	
}