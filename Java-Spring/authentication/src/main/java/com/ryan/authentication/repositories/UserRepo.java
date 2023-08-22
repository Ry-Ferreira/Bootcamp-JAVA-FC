package com.ryan.authentication.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ryan.authentication.models.User;

public interface UserRepo extends CrudRepository<User, Long>{

	User findByEmail(String email);

}
