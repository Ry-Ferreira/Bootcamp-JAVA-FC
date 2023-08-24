package com.ryan.eventos.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.ryan.eventos.models.User;
import com.ryan.eventos.repositories.UserRepo;


@Service
public class UserService {
	
	private final UserRepo userRepo;
	public UserService(UserRepo uRe) {
		this.userRepo = uRe;
	}
	
	//encontrar usuario a traves de email
	public User findEmail(String email) {
		return userRepo.findByEmail(email);
	}
	
	//encontrar usuario por ID de la sesion
	public User findUserId(Long id) {
		Optional<User> user = userRepo.findById(id);
		//isPresent() es un metodo de Optional
		if(user.isPresent()) {
			return user.get();
		}
		
		return null;
	}
	
	//register user
	
	public User registerUser(User user, BindingResult result) {
		
		User userExist = userRepo.findByEmail(user.getEmail());
		
		if(userExist != null) {
			result.rejectValue("email", "Matches", "Correo electronico ya en uso");
		}
		
		if(!user.getPassword().equals(user.getPasswordConfirmation())) {
			result.rejectValue("password", "Matches", "Password no coincide");
		}
		
		if(result.hasErrors()) {
			return null;
		}
		
		//HASH DEL PASSWORD
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
		
		return userRepo.save(user);
	}
	
	//autenticacion de usuario (LOGIN)
	
	public boolean authenthicateUser(String email, String password, BindingResult result) {
		
		User usuario = userRepo.findByEmail(email);
		
		if(usuario == null) {
			result.rejectValue("email", "Matches", "Email no valido");
			return false;
		} else {
			if(BCrypt.checkpw(password, usuario.getPassword())) {
				return true;
			} else {
				result.rejectValue("password", "Matches", "Password no valido");
				return false;
			}
			
		}
		
	}
	
}
