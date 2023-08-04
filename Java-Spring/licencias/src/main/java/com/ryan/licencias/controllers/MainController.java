package com.ryan.licencias.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ryan.licencias.models.Licencia;
import com.ryan.licencias.models.Persona;
import com.ryan.licencias.services.MainService;

import jakarta.validation.Valid;

@Controller
public class MainController {
	
	//INYECCION DE DEPENDENCIAS
	@Autowired
	private MainService mainService;
	
	
	@GetMapping("/persons/{id}")
	public String root(Model viewModel) {
		List<Persona> todosUsuarios = mainService.allPerson();
		viewModel.addAttribute("infoUsuario", todosUsuarios);
		return "index.jsp";
	}
	
	
	@GetMapping("/persons/new")
	public String formularioPersona(@ModelAttribute("persona") Persona persona) {		
		return "newPerson.jsp";
	}
	
	
	//CREAR PERSONA
	@PostMapping("/persons/new")
	public String crearPersona(@Valid @ModelAttribute("persona") Persona persona, BindingResult resultado) {
		
		if(resultado.hasErrors()) {
			return "newPerson.jsp";
		} 
		mainService.crearPersona(persona);
		
		return "redirect:/";
	}
	
	
	
	@GetMapping("/licenses/new")
	public String formularioLicencia(@ModelAttribute("licencia") Licencia licencia, Model viewModel) {
		
		//List<Persona> allUsers = mainService.allPerson();
		//viewModel.addAttribute("allUsers", allUsers);
		viewModel.addAttribute("allUsers", mainService.personasSinLic());
		return "newLic.jsp";
	}
	
	
	//CREAR LICENCIA
	@PostMapping("/licenses/new")
	public String crearLicencia(@Valid @ModelAttribute("licencia") Licencia licencia, 
			BindingResult resultado, Model viewModel) {
			
		if(resultado.hasErrors()) {
			//viewModel.addAttribute("allUsers", mainService.allPerson());
			return "newLic.jsp";
		} 
		mainService.crearLicencia(licencia);
		
		return "redirect:/";
	}
	
	
}
