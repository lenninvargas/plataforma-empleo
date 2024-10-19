package com.plataforma.empleo.entidad;

import java.time.LocalDate;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_empleo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
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
	
}
