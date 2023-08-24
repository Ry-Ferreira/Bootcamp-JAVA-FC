package com.ryan.eventos.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ryan.eventos.models.MessageModel;

public interface MessageRepo extends CrudRepository<MessageModel, Long>{

}
