package com.ryan.ProductosYCategorias.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ryan.ProductosYCategorias.models.Category;
import com.ryan.ProductosYCategorias.models.Product;

public interface ProductRepo extends CrudRepository<Product, Long>{
	
	List<Product> findAll();
	
	List<Product> findByCategoriesNotContains(Category category);
}
