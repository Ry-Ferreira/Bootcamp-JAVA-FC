package com.ryan.dojosyninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ryan.dojosyninjas.models.DojoModel;

public interface DojoRepo extends CrudRepository<DojoModel, Long>{
	
	List<DojoModel> findAll();
}
