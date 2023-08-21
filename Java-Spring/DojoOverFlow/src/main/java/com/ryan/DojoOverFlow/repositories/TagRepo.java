package com.ryan.DojoOverFlow.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ryan.DojoOverFlow.models.TagModel;

@Repository
public interface TagRepo extends CrudRepository<TagModel, Long>{

	TagModel findBySubject(String subject);
}
