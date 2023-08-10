package com.ryan.lenguajes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.ryan.lenguajes.models.LanguagesModel;
import com.ryan.lenguajes.services.LanguageService;

import jakarta.validation.Valid;



@Controller
public class MainController {
	
	@Autowired
	private LanguageService languageService;

	//VISTA PRINCIPAL
	@GetMapping("/languages")
	public String root(@ModelAttribute("language") LanguagesModel language, Model viewModel) {
		List<LanguagesModel> allLanguages = languageService.allLanguages();
		viewModel.addAttribute("languages", allLanguages);
		return "index.jsp";
	}
	
	
	//VISTA PARA EDITAR LANGUAGE
	@GetMapping("/languages/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model viewModel) {
		LanguagesModel language = languageService.findLanguage(id);
		viewModel.addAttribute("languages", language);
		return "/edit.jsp";
	}
	
	
	//VISTA DE INFORMACION LANGUAGE
	@GetMapping("/languages/{id}")
	public String show(@PathVariable("id") Long id, Model viewModel) {
		LanguagesModel language = languageService.findLanguage(id);
		viewModel.addAttribute("languages", language);
		return "/showInfo.jsp";
	}
	
	
	//CREAR LENGUAJE
	@PostMapping("/languages")
	public String newLanguage(@Valid @ModelAttribute("language") LanguagesModel language, BindingResult result, Model viewModel) {
		
		if(result.hasErrors()) {
			List<LanguagesModel> allLanguages = languageService.allLanguages();
			viewModel.addAttribute("languages", allLanguages);
			return "index.jsp";
		} else {
			languageService.createLanguage(language);
			return "redirect:/languages";
		}
	}
	
	
	//EDITAR UN LANGUAGE
	@PutMapping("/languages/edit/{id}")
	public String  update(
			@PathVariable("id")Long id, 
    		@RequestParam(value="name") String name, 
    		@RequestParam(value="version") String version, 
    		@RequestParam(value="creatorName") String creatorName) {
		
		LanguagesModel editLanguage = new LanguagesModel(id, name, version, creatorName);
				languageService.updateLanguage(editLanguage);
				return "redirect:/languages";
		//return languageService.updateLanguage(id, name, version, creatorName);
	}
	
	
	//EDITAR LANGUAGE
    @PutMapping("/edit/{id}")
    public String update(@Valid @ModelAttribute("language") LanguagesModel language, BindingResult result) {
        if (result.hasErrors()) {
            return "/edit.jsp";
        } else {
            languageService.updateLanguage(language);
            return "redirect:/languages";
        }
    }
	
	// DELETE LENGUAGE
	@GetMapping("/languages/{id}/delete")
	public String deleteLanguage(@PathVariable("id") Long id) {
		languageService.deleteLanguage(languageService.findLanguage(id));
		return "redirect:/languages";
	}
		 
	
}
