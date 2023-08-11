package com.ryan.ListaDeEstudiantes.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ryan.ListaDeEstudiantes.models.StudentsModel;

public interface StudentsRepositorie extends CrudRepository<StudentsModel, Long>{

	List<StudentsModel> findAll();
}
