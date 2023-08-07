package com.ryan.dojosyninjas.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ryan.dojosyninjas.models.NinjaModel;
import com.ryan.dojosyninjas.services.MainService;

import jakarta.validation.Valid;

@Controller
public class NinjaController {
	
		//INYECCION DE DEPENDENCIA ADECUADA
		private final MainService mainServ;
		public NinjaController(MainService service) {
			this.mainServ = service;
		}
		
		@GetMapping("/ninja/new")
		public String formNinja(@ModelAttribute("ninjaForm") NinjaModel ninja, Model viewModel) {
			//PASO TODOS LOS DOJOS Y NINJAS A INDEX.JSP
			viewModel.addAttribute("dojos", mainServ.todosDojos());
			return "/ninjas/newNinja.jsp";
		}
		
		//NUEVO NINJA	
		@PostMapping("/ninja/new")
		public String createNinja(@Valid @ModelAttribute("ninjaForm") NinjaModel ninja, BindingResult result, Model viewModel) {
			
			if(result.hasErrors()) {
				return "/dojos/newDojo.jsp";
			}
			
			viewModel.addAttribute("dojos", mainServ.todosDojos());
			mainServ.createNinja(ninja);
			return "redirect:/dojos";
		}
	
}
