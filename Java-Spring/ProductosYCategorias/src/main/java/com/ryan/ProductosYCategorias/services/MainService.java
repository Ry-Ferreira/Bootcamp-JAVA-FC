package com.ryan.ProductosYCategorias.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ryan.ProductosYCategorias.models.Category;
import com.ryan.ProductosYCategorias.models.CategoryProduct;
import com.ryan.ProductosYCategorias.models.Product;
import com.ryan.ProductosYCategorias.repositories.CategoryRepo;
import com.ryan.ProductosYCategorias.repositories.ProductCategoryRepo;
import com.ryan.ProductosYCategorias.repositories.ProductRepo;

@Service
public class MainService {
		
	//INYECCION DE DEPENDENCIAS
	private final ProductRepo productRepo;
	private final CategoryRepo categoryRepo;
	private final ProductCategoryRepo proCatRepo;
	public MainService(ProductRepo pRe, CategoryRepo cRe, ProductCategoryRepo pCRe) {
		this.productRepo = pRe;
		this.categoryRepo = cRe;
		this.proCatRepo = pCRe;
		
	}

	//METODOS CREAR	
	
	//PRODUCTO
	
	public Product crearProducto(Product producto) {
		return productRepo.save(producto);
	}
	
	
	//CATEGORIA
	
	public Category crearCategoria(Category categoria) {
		return categoryRepo.save(categoria);
	}
	
	//PRODUCTO CATEGORIA
	
	public CategoryProduct crearVinculo(CategoryProduct productoCategoria) {
		return proCatRepo.save(productoCategoria);
	}
	
	
	//METODOS LECTRURA	
	public List<Category> productoSinCategoria(Product product){
		return categoryRepo.findByProductsNotContains(product);
	}
	
	public List<Category> productoConCategoria(Product product){
		return categoryRepo.findByProductsWithCategories(product);
	}
	
	public Product unProducto(Long id) {
		return productRepo.findById(id).orElse(null);
	}
	
	public List<Product> todosProductos() {
		return productRepo.findAll();
	}
	
	public Category unaCategoria(Long id) {
		return categoryRepo.findById(id).orElse(null);
	}
	
	public List<Product> categoriaSinProducto(Category category){
		return productRepo.findByCategoriesNotContains(category);
	}
	
}
