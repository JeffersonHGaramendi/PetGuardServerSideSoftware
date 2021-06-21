package com.ditron.petguard.domain.repository;

import com.ditron.petguard.domain.model.OwnerPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerPaymentRepository extends JpaRepository<OwnerPayment, Long> {
}
