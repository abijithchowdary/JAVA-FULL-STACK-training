package com.capg.springboot.controller;

import org.springframework.web.bind.annotation.*;

/**
 * Order Controller
 * Handles order placement
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @PostMapping("/place/{productId}")
    public String placeOrder(@PathVariable Long productId) {
        return "Order service working for product " + productId;
    }
}