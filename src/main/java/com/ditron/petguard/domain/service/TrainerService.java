package com.ditron.petguard.domain.service;

import com.ditron.petguard.domain.model.Trainer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface TrainerService {
    Page<Trainer> getAllUsers(Pageable pageable);

    Trainer getUserById(Long userId);

    Trainer createUser(Trainer user);

    Trainer updateUser(Long userId,Trainer userDetails);

    ResponseEntity<?> deleteUser(Long userId);
}
