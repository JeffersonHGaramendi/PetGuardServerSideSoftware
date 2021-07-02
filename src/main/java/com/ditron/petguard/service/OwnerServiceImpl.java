package com.ditron.petguard.service;

import com.ditron.petguard.domain.model.Owner;
import com.ditron.petguard.domain.repository.OwnerRepository;
import com.ditron.petguard.domain.service.OwnerService;
import com.ditron.petguard.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceImpl implements OwnerService {
    @Autowired
    private OwnerRepository userRepository;
    @Override
    public Page<Owner> getAllOwners(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public Owner getOwnerById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
    }

    @Override
    public Owner createOwner(Owner user) {
        return userRepository.save(user);
    }

    @Override
    public Owner updateOwner(Long userId, Owner userRequest) {
        Owner user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
        return userRepository.save(
                user.setName(userRequest.getName())
                        .setLastname(userRequest.getLastname())
                        .setAge(userRequest.getAge())
                        .setPhoneNumber(userRequest.getPhoneNumber())
                        .setCreditCard(userRequest.getCreditCard())
                        .setEmail(userRequest.getEmail()));
    }

    @Override
    public ResponseEntity<?> deleteOwner(Long userId) {
        Owner user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
        userRepository.delete(user);
        return ResponseEntity.ok().build();
    }
}

