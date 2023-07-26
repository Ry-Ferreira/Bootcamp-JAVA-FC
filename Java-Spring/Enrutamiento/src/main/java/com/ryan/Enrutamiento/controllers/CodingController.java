package com.ryan.Enrutamiento.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodingController {
	
	@GetMapping("/coding")
	public String codingOne() {
		return "¡Hola Coding Dojo!";
	}
	
	@GetMapping("/coding/python")
	public String codingTwo() {
		return "¡Python/Django fue increíble!";
	}
	
	@GetMapping("/coding/java")
	public String codingThree() {
		return "¡Java/Spring es mejor!";
	}
	
}
