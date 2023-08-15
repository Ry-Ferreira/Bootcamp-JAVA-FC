package com.ryan.ProductosYCategorias.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ryan.ProductosYCategorias.models.Category;
import com.ryan.ProductosYCategorias.models.CategoryProduct;
import com.ryan.ProductosYCategorias.models.Product;
import com.ryan.ProductosYCategorias.services.MainService;

import jakarta.validation.Valid;

@Controller
public class CategoryController {
	
	private final MainService mainServ;
	public CategoryController(MainService service) {
		this.mainServ = service;
	}
	
	@GetMapping("/category/new")
	public String formProduct(@ModelAttribute("categoria") Category categoria) {
		
		return "nuevacategoria.jsp";
	}
	
	@PostMapping("/category/new")
	public String nuevoProducto(@Valid @ModelAttribute("catergoria") Category categoria, BindingResult result) {
		
		if(result.hasErrors()) {
			return "nuevacategoria.jsp";
		}
		
		mainServ.crearCategoria(categoria);
		return "redirect:/";
	}
	
	@GetMapping("/category/{idCategory}")
	public String mostrarCategoria(@PathVariable("idCategory") Long idCategory, 
			@ModelAttribute("asociacionCat") CategoryProduct asociacion,
			Model modelo) {
		Category categoria = mainServ.unaCategoria(idCategory);
		modelo.addAttribute("producto", mainServ.categoriaSinProducto(categoria));
		modelo.addAttribute("categoria", categoria);
		return "showcategory.jsp";
	}
}
