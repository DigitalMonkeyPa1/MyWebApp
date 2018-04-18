package com.project1.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project1.models.Category;
import com.project1.models.Product;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao
{
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Product> getAllProducts()
	{
		Session session = sessionFactory.getCurrentSession();
		String hqlQuery = "from Product";
		Query query = session.createQuery(hqlQuery);
		List<Product> products = query.list();
		System.out.println("Returning all products.....");
		return products;
	}

	public Product getProduct(int id)
	{
		Session session = sessionFactory.getCurrentSession();
		Product product = (Product) session.get(Product.class, id);
		System.out.println("Returning product "+product.getName()+", with id "+product.getId());
		return product;
	}

	public void deleteProduct(int id)
	{	
		Session session = sessionFactory.getCurrentSession();
		Product product = (Product) session.get(Product.class, id);
		System.out.println("Deleting product "+product.getName());
		session.delete(product);
	}

	public void addProduct(Product product)
	{
		Session session = sessionFactory.getCurrentSession();
		System.out.println("Adding product "+product.getName()+", with id "+product.getId());
		session.saveOrUpdate(product);
		System.out.println("Changing id of "+product.getName()+"to "+product.getId());
	}

	public void updateProduct(Product product)
	{
		Session session = sessionFactory.getCurrentSession();
		System.out.println("Updating product "+product.getName()+", with id "+product.getId());
		session.saveOrUpdate(product);
		System.out.println("Changing id of "+product.getName()+"to "+product.getId());
	}

	public List<Category> getAllCategories()
	{
		Session session = sessionFactory.getCurrentSession();
		System.out.println("Returning all products");
		String hqlQuery = "from Category";
		Query query = session.createQuery(hqlQuery);
		List<Category> categories = query.list();
		return categories;
	}
	
}
