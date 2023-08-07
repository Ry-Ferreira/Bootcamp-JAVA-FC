package com.ryan.dojosyninjas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ryan.dojosyninjas.models.DojoModel;
import com.ryan.dojosyninjas.services.MainService;

import jakarta.validation.Valid;

@Controller
public class DojoController {

	//INYECCION DE DEPENDENCIA ADECUADA
	private final MainService mainServ;
	public DojoController(MainService service) {
		this.mainServ = service;
	}
	
	@GetMapping("/dojos")
	public String index(Model viewModel) {
		viewModel.addAttribute("ninjas", mainServ.todosNinjas());
		viewModel.addAttribute("dojos", mainServ.todosDojos());
		return "/dojos/index.jsp";
	}
	
	@GetMapping("/dojo/new")
	public String formDojo(@ModelAttribute("dojo") DojoModel dojo) {
		
		return "/dojos/newDojo.jsp";
	}
	
	//NUEVO DOJO
	@PostMapping("/dojo/new")
	public String createDojo(@Valid @ModelAttribute("dojo") DojoModel dojo, BindingResult result) {
		
		if(result.hasErrors()) {
			return "/dojos/newDojo.jsp";
		}
		
		mainServ.createDojo(dojo);
		return "redirect:/";
	}
	
	@GetMapping("/dojo/{idDojo}")
	public String ninjasEnDojos(@PathVariable("idDojo") Long id, Model viewModel) {
		viewModel.addAttribute("dojo", mainServ.unDojo(id));
		return "/dojos/showInfo.jsp";
	}
}
