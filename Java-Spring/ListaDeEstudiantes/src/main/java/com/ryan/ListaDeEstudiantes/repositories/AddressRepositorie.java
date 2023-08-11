package com.ryan.ListaDeEstudiantes.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ryan.ListaDeEstudiantes.models.AddressModel;

public interface AddressRepositorie extends CrudRepository<AddressModel, Long> {
	
}
