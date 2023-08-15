package com.ryan.ProductosYCategorias.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ryan.ProductosYCategorias.models.CategoryProduct;
import com.ryan.ProductosYCategorias.models.Product;
import com.ryan.ProductosYCategorias.services.MainService;

import jakarta.validation.Valid;

@Controller
public class ProductController {

	private final MainService mainServ;
	public ProductController(MainService service) {
		this.mainServ = service;
	}
	
	@GetMapping("/products/new")
	public String formProduct(@ModelAttribute("producto") Product producto) {
		
		return "nuevoproducto.jsp";
	}
	
	@PostMapping("/products/new")
	public String nuevoProducto(@Valid @ModelAttribute("producto") Product producto, BindingResult result) {
		
		if(result.hasErrors()) {
			return "nuevoproducto.jsp";
		}
		
		mainServ.crearProducto(producto);
		return "redirect:/";
	}
	
	@GetMapping("/products/{idProduct}")
	public String mostrarProducto(@PathVariable("idProduct") Long idProduct, 
			@ModelAttribute("asociacion") CategoryProduct asociacion,
			Model modelo) {
		Product producto = mainServ.unProducto(idProduct);
		modelo.addAttribute("categorias", mainServ.productoSinCategoria(producto));
		modelo.addAttribute("producto", producto);
		return "showproduct.jsp";
	}
	
//	@GetMapping("/")
//	public String mostrarInfo(Model viewModel) {
//		List<Product> producto = mainServ.todosProductos();
//		viewModel.addAttribute("producto", producto);
//		return "index.jsp";
//	}
}
