package com.ryan.cadenas.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Cadenas {

	@RequestMapping("/")
	public String bienvenida(){
		return "Hola cliente!!, gracias por entrar hoy, esperemos tengas un lindo día";
	}
	
	@GetMapping("/random")
	public String login(){
		return "Spring Boot es genial!, es facil de usar y de trabajar!!";
	}
}
