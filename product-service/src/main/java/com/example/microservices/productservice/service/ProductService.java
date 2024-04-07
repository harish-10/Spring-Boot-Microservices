package com.example.microservices.productservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.microservices.productservice.dto.ProductRequest;
import com.example.microservices.productservice.dto.ProductResponse;
import com.example.microservices.productservice.model.Product;
import com.example.microservices.productservice.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

	private final ProductRepository productRepository;

	public Product createProduct(ProductRequest productRequest) {
		Product product = Product.builder().name(productRequest.name()).description(productRequest.description())
				.price(productRequest.price()).build();

		productRepository.save(product);
		log.info("Product {} is saved", product.getId());
		return product;
	}

	public List<ProductResponse> getAllProducts() {
		return productRepository.findAll().stream().map(product -> new ProductResponse(product.getId(),
				product.getName(), product.getDescription(), product.getPrice())).toList();
	}

}