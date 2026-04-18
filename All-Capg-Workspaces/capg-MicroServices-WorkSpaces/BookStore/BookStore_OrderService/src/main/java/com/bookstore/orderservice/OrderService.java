package com.bookstore.orderservice;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.client.BookClient;
import com.bookstore.dto.BookDto;
import com.bookstore.orderentity.Order;
import com.bookstore.orderrepository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private BookClient bookClient;

    public List<Order> getAllOrders() {
        return repository.findAll();
    }

    public Order getOrderById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public Order placeOrder(Order order) {

        System.out.println("Placing order for book ID: " + order.getBookId());

        BookDto book = bookClient.getBookById(order.getBookId());

        double total = book.getPrice() * order.getQuantity();

        order.setTotalPrice(total);
        order.setStatus("PLACED");
        order.setOrderDate(LocalDate.now());

        return repository.save(order);
    }

    public Order updateOrderStatus(Long id, Order updatedOrder) {

        Order order = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        order.setStatus(updatedOrder.getStatus());

        return repository.save(order);
    }

    public void deleteOrder(Long id) {
        repository.deleteById(id);
    }
}