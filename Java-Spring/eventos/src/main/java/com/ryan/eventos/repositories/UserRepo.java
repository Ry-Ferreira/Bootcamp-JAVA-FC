package com.ryan.eventos.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ryan.eventos.models.User;

public interface UserRepo extends CrudRepository<User, Long>{

	User findByEmail(String email);

}
