package com.ditron.petguard.controller;

import com.ditron.petguard.domain.model.Trainer;
import com.ditron.petguard.domain.service.TrainerService;
import com.ditron.petguard.resource.SaveTrainerResource;
import com.ditron.petguard.resource.TrainerResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class TrainersController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private TrainerService userService;

    @Operation(summary = "Get Trainers", description = "Get All Trainers by Page", tags = {"owners"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All Trainers returned", content = @Content(mediaType = "application/json"))

    })
    @GetMapping("/trainers")
    public Page<TrainerResource> getAllUser(Pageable pageable) {
        Page<Trainer> userPage = userService.getAllUsers(pageable);
        List<TrainerResource> resources = userPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());

        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary = "Get Trainer By ID", description = "Get Trainer by ID", tags = {"trainers"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Trainer returned", content = @Content(mediaType = "application/json"))

    })
    @GetMapping("/trainers/{trainerId}")
    public TrainerResource getUserById(
            @PathVariable Long trainerId) {
        return convertToResource(userService.getUserById(trainerId));
    }

    @Operation(summary = "Create a Trainer", description = "Create a Trainer", tags = {"trainers"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Trainer created", content = @Content(mediaType = "application/json"))

    })
    @PostMapping("/trainers/{trainerId}")
    public TrainerResource createTrainer(@Valid @RequestBody SaveTrainerResource resource) {
        Trainer trainer = convertToEntity(resource);
        return convertToResource(userService.createUser(trainer));
    }

    @Operation(summary = "Update a Trainer", description = "Update a Trainer", tags = {"trainers"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Trainer updated", content = @Content(mediaType = "application/json"))

    })
    @PutMapping("/trainers/{trainerId}")
    public TrainerResource updateUser(@PathVariable Long trainerId, @Valid @RequestBody SaveTrainerResource resource) {
        Trainer user = convertToEntity(resource);
        return convertToResource(userService.updateUser(trainerId, user));
    }

    @Operation(summary = "Delete a Trainer", description = "Delete a Trainer", tags = {"trainers"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Trainer deleted", content = @Content(mediaType = "application/json"))

    })
    @DeleteMapping("/trainers/{trainerId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long trainerId) {
        return userService.deleteUser(trainerId);
    }

    private Trainer convertToEntity(SaveTrainerResource resource) {
        return mapper.map(resource, Trainer.class);
    }

    private TrainerResource convertToResource(Trainer entity) {
        return mapper.map(entity, TrainerResource.class);
    }
}
