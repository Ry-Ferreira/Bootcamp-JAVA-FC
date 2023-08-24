package com.ryan.eventos.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ryan.eventos.models.EventModel;


public interface EventRepo extends CrudRepository<EventModel, Long> {

	List<EventModel> findByState(String state);
	
	List<EventModel> findByStateNotContains(String state);
}
