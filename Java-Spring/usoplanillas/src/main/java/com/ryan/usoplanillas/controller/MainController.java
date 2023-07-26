package com.ryan.usoplanillas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/root")
public class MainController {
	
	@RequestMapping("/primeraplantilla")
	public String raiz(Model modelo) {
		
		//Variable del metodo raiz
		String nombre = "Grace Hopper";
		String itemName = "Cooper Wire";
		double precio = 5.72;
		String descripcion = " Metal strips";
		
		// INCLUIR LAS VARIABLES ANTERIORES DENTRO DE UN OBJETO A TRAVES DE Model
		
		modelo.addAttribute("name", nombre);
		modelo.addAttribute("itemNombre", itemName);
		modelo.addAttribute("price", precio);
		modelo.addAttribute("desc", descripcion);
		
		return "index.jsp";
	}
	
}
