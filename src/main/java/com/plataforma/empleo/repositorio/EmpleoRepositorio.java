package com.plataforma.empleo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.plataforma.empleo.entidad.Empleo;

@Repository
public interface EmpleoRepositorio extends CrudRepository<Empleo, Integer>{
	
	@Query(value = "SELECT * FROM tb_empleo WHERE id_empleador =:id order by id_empleo desc", nativeQuery = true)
	List<Empleo> obtenerEmpleosDeEmpleador(Long id); 
	
	@Query(value = "SELECT * FROM tb_empleo order by id_empleo desc", nativeQuery = true)
	List<Empleo> obtenerEmpleos(); 
}
