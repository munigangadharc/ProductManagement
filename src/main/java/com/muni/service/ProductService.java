package com.muni.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muni.model.Product;
import com.muni.repository.ProductRepository;
@Service
public class ProductService {

	private final ProductRepository productRepository;
	@Autowired 
	
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public Optional<Product> getProduct(Long id) {
		return productRepository.findById(id);
	}

	public Product createproduct(Product product) {
		return productRepository.save(product);
		
	}
	
	public List<Product> composeListProducts(List<Product> product) {
		return productRepository.saveAll(product);
		
	}

	public void deleteProduct(Long id) {
		 productRepository.deleteById(id);
	}

}
