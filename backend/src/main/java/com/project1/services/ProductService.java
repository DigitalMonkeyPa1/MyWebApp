package com.project1.services;

import java.util.List;

import com.project1.models.Category;
import com.project1.models.Product;

public interface ProductService
{
	List<Product> getAllProducts();
	Product getProduct(int id);
	void deleteProduct(int id);
	void addProduct(Product product);
	void updateProduct(Product product);
	List<Category> getAllCategories();
}
