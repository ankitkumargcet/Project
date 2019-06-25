package com.alerter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alerter.entity.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, String> {

}
