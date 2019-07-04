package com.alerter.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alerter.entity.Product;
import com.alerter.repository.ProductRepository;
import com.alerter.util.ProductDataToCSV;

@RestController
@RequestMapping(path = "/product")
public class ProductController {

	@Autowired
	private ProductRepository repository;

	@GetMapping(produces = "text/csv")
	public void getAllProduct(HttpServletResponse response) throws IOException {
		List<Product> products = (List<Product>) repository.findAll();
		ProductDataToCSV.write(response.getWriter(), products);
	}

	@GetMapping(path = "/{id}")
	public Optional<Product> getProductById(@PathVariable(required = true) String id) {
		return repository.findById(id);
	}
}
