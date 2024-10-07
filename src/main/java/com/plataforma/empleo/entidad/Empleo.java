package com.plataforma.empleo.entidad;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.*;
import jakarta.persistence.Id;

@Entity
@Table(name = "tb_empleo")

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
	

	public Integer getId_empleo() {
		return id_empleo;
	}

	public void setId_empleo(Integer id_empleo) {
		this.id_empleo = id_empleo;
	}

	public Empleador getEmpleador() {
		return empleador;
	}

	public void setEmpleador(Empleador empleador) {
		this.empleador = empleador;
	}

	public Habilidad getHabilidad() {
		return habilidad;
	}

	public void setHabilidad(Habilidad habilidad) {
		this.habilidad = habilidad;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


	@Override
	public String toString() {
		return "Empleo [id_empleo=" + id_empleo + ", empleador=" + empleador + ", habilidad=" + habilidad + ", titulo="
				+ titulo + ", descripcion=" + descripcion + ", fecha=" + fecha + "]";
	}
	

}
