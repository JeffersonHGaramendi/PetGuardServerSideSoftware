package com.ditron.petguard.domain.service;

import com.ditron.petguard.domain.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface OrderService {
    Page<Order> getAllOrders(Pageable pageable);

    Order getOrderById(Long orderId);

    Order createOrder(Order order);

    Order updateOrder(Long orderId, Order order);

    ResponseEntity<?> deleteOrder(Long orderId);

    Page<Order> getAllOrdersByOwnerId(Long ownerId, Pageable pageable);
}