package com.project1.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.project1.models.Category;
import com.project1.models.Product;
import com.project1.services.ProductService;

@Controller
public class ProductController
{
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ServletContext servletContext;
	
	@RequestMapping(value="/hello")
	public ModelAndView getHello()
	{
		return new ModelAndView("hello", "data", "Howdy!");
	}
	
	@RequestMapping(value="/allProducts")
	public ModelAndView getAllProducts()
	{
		List<Product> products = productService.getAllProducts();
		System.out.println(products);
		return new ModelAndView("productsList", "productsAttribute", products);
	}
	
	@RequestMapping(value="/allProducts/{id}")
	public ModelAndView getThisProduct(@PathVariable int id)
	{
		Product p = productService.getProduct(id);
		return new ModelAndView("productOverview", "productAttribute", p);
	}
	
	@RequestMapping(value="/admin/deleteProduct/{id}")
	public String deleteProduct(@PathVariable int id, HttpServletRequest request)
	{
		productService.deleteProduct(id);
		// or use servletContext bean
		String rootDirectory = request.getServletContext().getRealPath("/");
		Path path = Paths.get(rootDirectory+"/WEB-INF/resources/images/"+id+".png");
		if(Files.exists(path))
		{
			try
			{
				Files.delete(path);
			}
			catch (IOException e){e.printStackTrace();}
		}
		
		return "redirect:/allProducts"; // not jsp
	}
	
	// ADD PRODUCT
	/*
	@RequestMapping(value="/admin/addProductForm")
	public ModelAndView getAddProductForm()
	{
		return new ModelAndView("addProductForm", "productAttribute", new Product());
	}*/
	
	@RequestMapping(value="/admin/addProductForm")
	public String getAddProductForm(Model model)
	{
		Product p = new Product();
		List<Category> cats = productService.getAllCategories();
		model.addAttribute("productAttribute", p);
		model.addAttribute("categoriesAttribute", cats);
		return "addProductForm"; // .jsp
	}
	/*
	@RequestMapping(value="/admin/addProduct")
	public String addProduct(@Valid @ModelAttribute(name="productAttribute") Product product, BindingResult result)
	{
		if(result.hasErrors())
		{
			return "addProductForm";
		}
		productService.addProduct(product);
		return "redirect:/allProducts";
	}
	*/
	@RequestMapping(value="/admin/addProduct")
	public String addProduct(@Valid @ModelAttribute(name="productAttribute") Product product, BindingResult result, Model model)
	{
		if(result.hasErrors())
		{
			System.out.println("ADD: Found errors in new Product details.");
			List<Category> cats = productService.getAllCategories();
			model.addAttribute("categoriesAttribute", cats);
			return "addProductForm";
		}
		productService.addProduct(product);
		
		// creating and saving image, doing after DB operations is no problem, bcoz image is not going into DB
		MultipartFile productImage = product.getImage();
		String rootDirectory = servletContext.getRealPath("/");
		Path path = Paths.get(rootDirectory+"/WEB-INF/assets/images/"+product.getId()+".png");		
		try
		{
			productImage.transferTo(new File(path.toString()));
		}
		catch (IllegalStateException e) {e.printStackTrace();}
		catch (IOException e) {e.printStackTrace();}
		
		return "redirect:/allProducts"; // not jsp
	}
	
	
	// UPDATE PRODUCT
	/*
	 @RequestMapping(value="/admin/updateProductForm/{id}")
	public ModelAndView getUpdateProductForm(@PathVariable int id)
	{
		Product p = productService.getProduct(id);
		return new ModelAndView("updateProductForm", "productAttribute", p);
	}
	*/
	
	@RequestMapping(value="/admin/updateProductForm/{id}")
	public String getUpdateProductForm(@PathVariable int id, Model model)
	{
		Product p = productService.getProduct(id);
		List<Category> cats = productService.getAllCategories();
		model.addAttribute("productAttribute", p);
		model.addAttribute("categoriesAttribute", cats);
		return "updateProductForm"; // .jsp
	}
	
	@RequestMapping(value="/admin/updateProduct")
	public String updateProduct(@Valid @ModelAttribute(name="productAttribute") Product product, BindingResult result, Model model)
	{
		if(result.hasErrors())
		{
			System.out.println("UPDATE: Found errors in new Product details.");
			List<Category> cats = productService.getAllCategories();
			model.addAttribute("categoriesAttribute", cats);
			return "updateProductForm"; // .jsp
		}
		productService.updateProduct(product);
		
		// creating and saving image, doing after DB operations is no problem, bcoz image is not going into DB
		MultipartFile productImage = product.getImage();
		System.out.println("Uploaded Image => name : "+productImage.getName()+", path : "+productImage.getOriginalFilename());
		if (productImage.getOriginalFilename() != "")
		{
			System.out.println("Uploading new image");
			String rootDirectory = servletContext.getRealPath("/");
			
			Path path = Paths.get(rootDirectory+"/WEB-INF/assets/images/"+product.getId()+".png");		
			try
			{
				productImage.transferTo(new File(path.toString()));
			}
			catch (IllegalStateException e) {e.printStackTrace();}
			catch (IOException e) {e.printStackTrace();}
		}
		
		return "redirect:/allProducts"; // not jsp
	}
	
	
	@RequestMapping(value="/searchByCategory")
	public ModelAndView searchByCategory(@RequestParam String searchCategory)//, Model model)
	{
		System.out.println("SearchByCategory: "+searchCategory);
		searchCategory = searchCategory.equalsIgnoreCase("all") ? "" : searchCategory;
		
		ModelAndView mV = new ModelAndView("productsList");
		
		mV.addObject("searchAttribute", searchCategory);
		//model.addAttribute("searchAttribute", searchCategory);

		System.out.println("SearchByCategory after edit: "+searchCategory);
		
		List<Product> products = productService.getAllProducts();
		//model.addAttribute("productsAttribute", products);
		mV.addObject("productsAttribute", products);
		
		return mV; //"productsList";
	}
	
	
}
