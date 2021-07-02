package com.ditron.petguard.domain.service;

import com.ditron.petguard.domain.model.Owner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface OwnerService {
    Page<Owner> getAllOwners(Pageable pageable);

    Owner getOwnerById(Long userId);

    Owner createOwner(Owner user);

    Owner updateOwner(Long userId,Owner userDetails);

    ResponseEntity<?> deleteOwner(Long userId);
}

