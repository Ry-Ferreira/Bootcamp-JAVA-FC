package com.ryan.ProductosYCategorias.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ryan.ProductosYCategorias.models.CategoryProduct;

public interface ProductCategoryRepo extends CrudRepository<CategoryProduct, Long>{

	
}
