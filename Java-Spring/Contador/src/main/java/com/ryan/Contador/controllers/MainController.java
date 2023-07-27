package com.ryan.Contador.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {

	//METODOS DE CLASE
	private void setContadorSesion(HttpSession sesion, int numeroVeces) {
		sesion.setAttribute("contador", numeroVeces);
	}
	
	private int getContadorSesion(HttpSession sesion) {
		Object valorSesion = sesion.getAttribute("contador");
		
		if(valorSesion == null) {
			setContadorSesion(sesion, 0);
			
			valorSesion = sesion.getAttribute("contador");
		} 
		return (int) valorSesion;
	}
	
	@GetMapping("/")
		public String index(HttpSession sesion){
			System.out.println(sesion.getAttribute("contador") + " antes del seteo");
			
			int conteoActual = getContadorSesion(sesion);
			
			System.out.println(sesion.getAttribute("contador") + " luego del seteo");
			
			setContadorSesion(sesion, conteoActual+1); 
			
			return "index.jsp";	
		}
	
	@GetMapping("/contador")
		public String contador(HttpSession sesion, Model modelo) {
			modelo.addAttribute("contador", getContadorSesion(sesion));
			return "contador.jsp";
		}
	
	@GetMapping("/reset")
		public String reset(HttpSession sesion) {
			sesion.invalidate();
			return "redirect:/contador";
		}
	
	
	
	
	
}
