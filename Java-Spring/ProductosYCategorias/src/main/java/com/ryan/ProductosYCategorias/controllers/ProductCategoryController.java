package com.ryan.ProductosYCategorias.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ryan.ProductosYCategorias.models.CategoryProduct;
import com.ryan.ProductosYCategorias.services.MainService;

@Controller
public class ProductCategoryController {

	//INYECTAR DEPENDENCIAS
	private final MainService mainServ;
	public ProductCategoryController(MainService mainS) {
		this.mainServ = mainS;
	}
	
	
	
	@PostMapping("/aso/{idProducto}")
	public String asociarProductoCategoria(@PathVariable("idProducto") Long idProducto,
			@ModelAttribute("asociacion") CategoryProduct productosCategorias, Model viewModel,
			BindingResult resultado) {
		
		if(resultado.hasErrors()) {
			return "showproduct.jsp";
		}
		
		mainServ.crearVinculo(productosCategorias);
		return "redirect:/products/"+ idProducto;
	}
	
	@PostMapping("/asoCat/{idCategory}")
	public String asociarCategoriaProducto(@PathVariable("idCategory") Long idCategory,
			@ModelAttribute("asociacionCat") CategoryProduct productosCategorias, Model viewModel,
			BindingResult resultado) {
		
		if(resultado.hasErrors()) {
			return "showcategory.jsp";
		}
		
		mainServ.crearVinculo(productosCategorias);
		return "redirect:/category/"+ idCategory;
	}
}
