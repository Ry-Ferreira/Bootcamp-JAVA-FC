package com.ryan.licencias.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ryan.licencias.models.Licencia;
import com.ryan.licencias.models.Persona;

@Repository
public interface LicenciaRepo extends CrudRepository<Licencia, Long> {
	
	List<Licencia> findAll();
	
	public Licencia findTopByOrderByNumberDesc();
}
