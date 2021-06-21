package com.ditron.petguard.domain.service;

import com.ditron.petguard.domain.model.OwnerPayment;

import org.springframework.http.ResponseEntity;

public interface OwnerPaymentService {

    OwnerPayment getUserPaymentMethodById(Long userPaymentId);

    OwnerPayment createUserPaymentMethod(OwnerPayment userPayment);

    OwnerPayment updateUserPaymentMethod(Long userPaymentId, OwnerPayment userPaymentDetails);

    ResponseEntity<?> deleteUserPaymentMethod(Long userPaymentMId);

}
