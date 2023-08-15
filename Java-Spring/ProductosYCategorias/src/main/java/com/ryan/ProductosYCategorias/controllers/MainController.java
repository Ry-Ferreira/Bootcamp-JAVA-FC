package com.ryan.ProductosYCategorias.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.ryan.ProductosYCategorias.models.Product;
import com.ryan.ProductosYCategorias.services.MainService;

@Controller
public class MainController {

	private final MainService mainServ;
	public MainController(MainService service) {
		this.mainServ = service;
	}
	
	
	@GetMapping("/")
	public String root(Model viewModel) {
		List<Product> producto = mainServ.todosProductos();
		viewModel.addAttribute("producto", producto);
		return "index.jsp";
	}
}
