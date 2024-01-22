package com.belajarspring.repo;

import org.springframework.data.repository.CrudRepository;

import com.belajarspring.entity.Product;

public interface ProductRepo extends CrudRepository<Product, Long> {
     
}
