package com.plataforma.empleo.entidad;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Solicitud_Empleo {
	
	@Id
	private Long id_solicitud;
	
	
	private Long id_empleo;
	
	
	private Long id_empleado;
	
	
	private Boolean estado;
	
	
	private BigDecimal precio;
	
	
	private Date fecha_solicitud;
	
	

}