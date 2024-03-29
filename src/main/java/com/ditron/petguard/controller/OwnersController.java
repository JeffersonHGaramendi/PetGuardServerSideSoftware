package com.ditron.petguard.controller;

import com.ditron.petguard.domain.model.Owner;
import com.ditron.petguard.domain.service.OwnerService;
import com.ditron.petguard.resource.OwnerResource;
import com.ditron.petguard.resource.SaveOwnerResource;
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
public class OwnersController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private OwnerService ownerService;

    @Operation(summary = "Get Owners", description = "Get All Owners by Page", tags = {"owners"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All Owners returned", content = @Content(mediaType = "application/json"))

    })
    @GetMapping("/owners")
    public Page<OwnerResource> getAllOwners(Pageable pageable) {
        Page<Owner> userPage = ownerService.getAllOwners(pageable);
        List<OwnerResource> resources = userPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());

        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary = "Get Owner By ID", description = "Get Owner by ID", tags = {"owners"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Owner returned", content = @Content(mediaType = "application/json"))

    })
    @GetMapping("/owners/{ownerId}")
    public OwnerResource getOwnerById(
            @PathVariable Long ownerId) {
        return convertToResource(ownerService.getOwnerById(ownerId));
    }

    @Operation(summary = "Create a Owner", description = "Create a Owner", tags = {"owners"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Owner created", content = @Content(mediaType = "application/json"))

    })
    @PostMapping("/owners/{ownerId}")
    public OwnerResource createOwner(@Valid @RequestBody SaveOwnerResource resource) {
        Owner owner = convertToEntity(resource);
        return convertToResource(ownerService.createOwner(owner));
    }

    @Operation(summary = "Update a Owner", description = "Update a Owner", tags = {"owners"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Owner updated", content = @Content(mediaType = "application/json"))

    })
    @PutMapping("/owners/{ownerId}")
    public OwnerResource updateOwner(@PathVariable Long ownerId, @Valid @RequestBody SaveOwnerResource resource) {
        Owner user = convertToEntity(resource);
        return convertToResource(ownerService.updateOwner(ownerId, user));
    }

    @Operation(summary = "Delete a Owner", description = "Delete a Owner", tags = {"owners"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Owner deleted", content = @Content(mediaType = "application/json"))

    })
    @DeleteMapping("/owners/{ownerId}")
    public ResponseEntity<?> deleteOwner(@PathVariable Long ownerId) {
        return ownerService.deleteOwner(ownerId);
    }

    private Owner convertToEntity(SaveOwnerResource resource) {
        return mapper.map(resource, Owner.class);
    }

    private OwnerResource convertToResource(Owner entity) {
        return mapper.map(entity, OwnerResource.class);
    }
}
