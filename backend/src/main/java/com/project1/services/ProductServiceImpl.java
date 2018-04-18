package com.project1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project1.dao.ProductDao;
import com.project1.models.Category;
import com.project1.models.Product;

@Service
public class ProductServiceImpl implements ProductService
{
	@Autowired
	private ProductDao productDao;
	
	public List<Product> getAllProducts()
	{
		return productDao.getAllProducts();
	}

	public Product getProduct(int id)
	{
		return productDao.getProduct(id);
	}

	public void deleteProduct(int id)
	{
		productDao.deleteProduct(id);
	}

	public void addProduct(Product product)
	{
		productDao.addProduct(product);
	}

	public void updateProduct(Product product) 
	{
		productDao.updateProduct(product);
	}

	public List<Category> getAllCategories()
	{
		return productDao.getAllCategories();
	}
	
}
