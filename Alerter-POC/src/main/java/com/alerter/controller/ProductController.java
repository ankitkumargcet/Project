package com.alerter.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alerter.entity.Product;
import com.alerter.repository.ProductRepository;

@RestController
@RequestMapping(path = "/product")
public class ProductController {

	@Autowired
	private ProductRepository repository;

	@GetMapping
	public Iterable<Product> getAllProduct() {
		return repository.findAll();
	}

	@GetMapping(path = "/{id}")
	public Optional<Product> getProductById(@PathVariable(required = true) String id) {
		return repository.findById(id);
	}
}
