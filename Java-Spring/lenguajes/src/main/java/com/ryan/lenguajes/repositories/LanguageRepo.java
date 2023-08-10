package com.ryan.lenguajes.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ryan.lenguajes.models.LanguagesModel;

public interface LanguageRepo extends CrudRepository<LanguagesModel, Long>{

	
	List<LanguagesModel> findAll();
	
	List<LanguagesModel> findByNameContaining(String search);
	
	Long countByNameContaining(String search);
	
	Long deleteByNameStartingWith(String search);
}
