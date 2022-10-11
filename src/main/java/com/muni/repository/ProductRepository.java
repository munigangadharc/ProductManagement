package com.muni.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.muni.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
