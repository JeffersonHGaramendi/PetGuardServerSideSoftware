package com.ditron.petguard.service;


import com.ditron.petguard.domain.model.Trainer;
import com.ditron.petguard.domain.repository.TrainerRepository;
import com.ditron.petguard.domain.service.TrainerService;
import com.ditron.petguard.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TrainerServiceImpl implements TrainerService {
    @Autowired
    private TrainerRepository userRepository;
    @Override
    public Page<Trainer> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public Trainer getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
    }

    @Override
    public Trainer createUser(Trainer user) {
        return userRepository.save(user);
    }

    @Override
    public Trainer updateUser(Long userId, Trainer userRequest) {
        Trainer user = userRepository.findById(userId)
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
    public ResponseEntity<?> deleteUser(Long userId) {
        Trainer user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
        userRepository.delete(user);
        return ResponseEntity.ok().build();
    }
}
