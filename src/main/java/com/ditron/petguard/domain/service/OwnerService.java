package com.ditron.petguard.domain.service;

import com.ditron.petguard.domain.model.Owner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface OwnerService {
    Page<Owner> getAllUsers(Pageable pageable);

    Owner getUserById(Long userId);

    Owner createUser(Owner user);

    Owner updateUser(Long userId,Owner userDetails);

    ResponseEntity<?> deleteUser(Long userId);
}
