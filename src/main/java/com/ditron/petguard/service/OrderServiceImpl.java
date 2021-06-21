package com.ditron.petguard.service;

import com.ditron.petguard.domain.model.Order;
import com.ditron.petguard.domain.repository.OrderRepository;
import com.ditron.petguard.domain.service.OrderService;
import com.ditron.petguard.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderRepository userRepository;


    public Page<Order> getAllOrders(Pageable pageable) {
        return this.orderRepository.findAll(pageable);
    }
    //

    public Page<Order> getAllOrdersByUserId(Long userId, Pageable pageable) {
        return orderRepository.findByUserId(userId,pageable);
    }

    //
    public Order getOrderById(Long orderId) {
        return (Order) this.orderRepository.findById(orderId).orElseThrow(() -> {
            return new ResourceNotFoundException("Order", "Id", orderId);
        });
    }

    public Order createOrder(Order order) {
        return (Order) this.orderRepository.save(order);
    }

    public Order updateOrder(Long orderId, Order orderDetails) {
        return (Order) this.orderRepository.findById(orderId).map((order) -> {
            order.setAddress(orderDetails.getAddress());
            order.setStartedAt(orderDetails.getStartedAt());
            order.setFinishedAt(orderDetails.getFinishedAt());
            return (Order)this.orderRepository.save(order);
        }).orElseThrow(() -> {
            return new ResourceNotFoundException("Order", "Id", orderId);
        });
    }

    public ResponseEntity<?> deleteOrder(Long orderId) {
        return (ResponseEntity)this.orderRepository.findById(orderId).map((order) -> {
            this.orderRepository.delete(order);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> {
            return new ResourceNotFoundException("Order", "Id", orderId);
        });
    }
}
