package com.ditron.petguard.service;

import com.ditron.petguard.domain.model.OwnerPayment;
import com.ditron.petguard.domain.repository.OwnerPaymentRepository;
import com.ditron.petguard.domain.service.OwnerPaymentService;
import com.ditron.petguard.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OwnerPaymentServiceImpl implements OwnerPaymentService {
    @Autowired
    private OwnerPaymentRepository userPaymentMethodRepository;



    public OwnerPayment getUserPaymentMethodById(Long userPaymentMethodId) {
        return userPaymentMethodRepository.findById(userPaymentMethodId)
                .orElseThrow(() -> new ResourceNotFoundException("UserPaymentMethod", "Id", userPaymentMethodId));
    }

    public OwnerPayment createUserPaymentMethod(OwnerPayment userPaymentMethod) {
        return userPaymentMethodRepository.save(userPaymentMethod);
    }


    public OwnerPayment updateUserPaymentMethod(Long userPaymentMethodId, OwnerPayment userPaymentMethodRequest) {
        OwnerPayment userPaymentMethod = userPaymentMethodRepository.findById(userPaymentMethodId)
                .orElseThrow(() -> new ResourceNotFoundException("UserPaymentMethod", "Id", userPaymentMethodId));
        return userPaymentMethodRepository.save(
                userPaymentMethod.setCardNumber(userPaymentMethod.getCardNumber())
                        .setOwnerName(userPaymentMethod.getOwnerName())
                        .setDueDate(userPaymentMethod.getDueDate())
                        .setCv(userPaymentMethod.getCv()));

    }


    public ResponseEntity<?> deleteUserPaymentMethod(Long userPaymentMethodId) {
        OwnerPayment userPaymentMethod = userPaymentMethodRepository.findById(userPaymentMethodId)
                .orElseThrow(() -> new ResourceNotFoundException("UserPaymentMethod", "Id", userPaymentMethodId));
        userPaymentMethodRepository.delete(userPaymentMethod);
        return ResponseEntity.ok().build();
    }
}
