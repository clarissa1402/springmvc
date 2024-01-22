package com.belajarspring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.belajarspring.entity.Product;
import com.belajarspring.repo.ProductRepo;

import jakarta.transaction.Transactional;
import utils.RandomNumber;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepo repo;

    public Iterable<Product> findAll(){
        return repo.findAll();
    }

    // if the object already has id, then it will update but if the object doesn't have id, it will create new object 
    public void upsertProduct(Product product)
    {
        repo.save(product);
    }

    public void deleteProductById(long id)
    {
        repo.deleteById(id);
    }

    public Optional<Product> findById(long id)
    {
        return repo.findById(id);
    }

}
