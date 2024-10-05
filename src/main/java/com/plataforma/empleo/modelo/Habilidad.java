package com.plataforma.empleo.modelo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_habilidad")
@Getter
@Setter
@ToString
public class Habilidad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_habilidad")
	private Integer id;
	
	private String habilidad;
	
	@OneToMany(mappedBy = "habilidad")
	private List<Empleado> empleados;
	
	@OneToMany(targetEntity = Empleo.class, mappedBy = "habilidad")
	private List<Empleo> empleos;
}
