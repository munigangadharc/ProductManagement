package com.muni.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.muni.model.Product;
import com.muni.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping(path = "/fetchAllProduct",  produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Product> fetchAllProducts()
	{
		return productService.getAllProducts();
		
	}
	
	
	@GetMapping(path = "fetchProductByName" ,produces = MediaType.APPLICATION_JSON_VALUE)
	public Product fetchProductByName(@RequestParam String name)
	{
		Product returnValue = new Product();
		productService.getAllProducts();
		for(Product prod : productService.getAllProducts())
		{
			if(prod.getName().equalsIgnoreCase(name))
			{
				prod.setCost(prod.getCost() - (prod.getCost()*prod.getOffer())/100);
			}
			return prod;
		}
		return returnValue;

	}
	
	@DeleteMapping(path = "deleteProductName" ,produces = MediaType.APPLICATION_JSON_VALUE )
	public Long deleteProductName(@RequestParam Long id)
	{
		
		productService.deleteProduct(id);
		
		return id;

	}
	
	@PostMapping 
	public List<Product> createProduct(@RequestBody List<Product> product)
	{
		return productService.composeListProducts(product);
	}
	
}

