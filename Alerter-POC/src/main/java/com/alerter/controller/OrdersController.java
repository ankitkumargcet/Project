package com.alerter.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alerter.entity.Orders;
import com.alerter.repository.OrderRepository;

@RestController
@RequestMapping(path = "/orders")
public class OrdersController {
	@Autowired
	private OrderRepository repository;

	@GetMapping
	public Iterable<Orders> getAllOrders() {
		return repository.findAll();
	}

	@GetMapping(path = "/{id}")
	public Optional<Orders> getOrdersById(@PathVariable(required = true) String id) {
		return repository.findById(id);
	}

}
