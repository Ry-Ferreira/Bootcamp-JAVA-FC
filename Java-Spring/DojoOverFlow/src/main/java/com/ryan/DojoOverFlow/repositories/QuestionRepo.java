package com.ryan.DojoOverFlow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ryan.DojoOverFlow.models.QuestionModel;

@Repository
public interface QuestionRepo extends CrudRepository<QuestionModel, Long>{

	List<QuestionModel> findAll();
}
