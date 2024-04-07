package com.example.microservices.productservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.microservices.productservice.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

}
