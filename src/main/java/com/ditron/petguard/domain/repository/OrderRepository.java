package com.ditron.petguard.domain.repository;

import com.ditron.petguard.domain.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    Page<Order> findByOwnerId(Long ownerId, Pageable pageable);
}
