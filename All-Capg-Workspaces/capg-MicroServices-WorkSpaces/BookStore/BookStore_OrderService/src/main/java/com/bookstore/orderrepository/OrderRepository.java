package com.bookstore.orderrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.orderentity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	
}
