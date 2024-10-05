package com.plataforma.empleo.modelo;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_empleador")
@Getter
@Setter
@ToString
public class Empleador extends Persona{

	@OneToMany(targetEntity = Empleo.class, mappedBy = "empleador")
	private List<Empleo> empleos;
}
