package com.ryan.EncuestaDojo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {

	@RequestMapping("/")
	public String index(HttpSession sesion) {
		return "index.jsp";
	}
	
	@RequestMapping("/result")
	public String result(Model modelo, HttpSession sesion) {
		
		modelo.addAttribute("name", sesion.getAttribute("name"));
		modelo.addAttribute("location", sesion.getAttribute("location"));
		modelo.addAttribute("language", sesion.getAttribute("language"));
		modelo.addAttribute("comment", sesion.getAttribute("comment"));
		
		return "result.jsp";
	}
	
	@RequestMapping(value="/verificar", method=RequestMethod.POST)
	public String validar(
			@RequestParam(value="name") String name, 
			@RequestParam(value="location") String location, 
			@RequestParam(value="language") String language, 
			@RequestParam(value="comment") String comment, 
			RedirectAttributes rAtt, HttpSession sesion) {
		
		
		//VALIDACION DE DATOS
		if(name.equals("")) {
			rAtt.addFlashAttribute("errorName", "Por favor, ingresa un nombre");
			return "redirect:/";
		} 
		if(location.equals("")) {
			rAtt.addFlashAttribute("errorLocation", "Por favor, ingresa una localidad");
			return "redirect:/";
		}
		if(language.equals("")) {
			rAtt.addFlashAttribute("errorLanguage", "Por favor, ingresa un idioma");
			return "redirect:/";
		}
		if(comment.equals("")) {
			rAtt.addFlashAttribute("errorComment", "No has agregado ningun comentario");
			return "redirect:/result";
		}
		
		sesion.setAttribute("name", name);
		sesion.setAttribute("location", location);
		sesion.setAttribute("language", language);
		sesion.setAttribute("comment", comment);
		
		return "redirect:/result";
	}
}
