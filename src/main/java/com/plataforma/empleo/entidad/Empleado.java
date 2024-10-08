package com.plataforma.empleo.entidad;

import java.math.BigDecimal;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Empleado extends Persona {

	
	private Long id_habilidad;
	
	private BigDecimal calificacion;
	
}