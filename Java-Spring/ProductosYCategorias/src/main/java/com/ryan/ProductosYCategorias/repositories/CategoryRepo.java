package com.ryan.ProductosYCategorias.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ryan.ProductosYCategorias.models.Category;
import com.ryan.ProductosYCategorias.models.Product;

public interface CategoryRepo extends CrudRepository<Category, Long>{

		List<Category> findAll();
	
		List<Category> findByProductsNotContains(Product producto);
}
