package com.ryan.Enrutamiento.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DojoController {
	
	@GetMapping(path = "/dojo")
	public String dojoOne() {
		
		return "¡El Dojo es increíble!";	
	}
	
	@GetMapping(path = "/burbank-dojo")
	public String dojoTwo() {
		
		return "El Dojo Burbank está localizado al sur de California";	
	}
	
	@GetMapping(path = "/san-jose")
	public String dojoThree() {
		
		return "El Dojo SJ es el cuartel general";
	}
	
}
