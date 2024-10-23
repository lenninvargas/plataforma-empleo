package com.plataforma.empleo.entidad;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_habilidad")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Habilidad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nombre;
	
	@OneToMany(mappedBy = "id_habilidad", targetEntity = Empleado.class)
	private List<Empleado> empleados;

	public Habilidad(String nombre) {
		super();
		this.nombre = nombre;
	}
}

