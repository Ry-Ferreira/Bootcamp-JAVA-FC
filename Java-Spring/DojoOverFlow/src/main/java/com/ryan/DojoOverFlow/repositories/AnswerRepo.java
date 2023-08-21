package com.ryan.DojoOverFlow.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ryan.DojoOverFlow.models.AnswerModel;

@Repository
public interface AnswerRepo extends CrudRepository<AnswerModel, Long>{

}
