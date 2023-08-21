package com.ryan.DojoOverFlow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ryan.DojoOverFlow.models.QuestionTagModel;

@Repository
public interface QuestionAndTagRepo extends CrudRepository<QuestionTagModel, Long>{

	List<QuestionTagModel> findAll();
}
