package com.ditron.petguard.controller;

import com.ditron.petguard.domain.model.OwnerPayment;
import com.ditron.petguard.domain.service.OwnerPaymentService;
import com.ditron.petguard.resource.OwnerPaymentResource;
import com.ditron.petguard.resource.SaveOwnerPaymentResource;
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
public class OwnerPaymentsController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private OwnerPaymentService userPaymentMethodService;

    @Operation(summary = "Get OwnerPayment By ID", description = "Get OwnerPayment by ID", tags = {"ownerPayments"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "UserPaymentMethod returned", content = @Content(mediaType = "application/json"))

    })
    @GetMapping("/ownerPayments/{ownerPaymentId}")
    public OwnerPaymentResource getUserPaymentMethodById(
            @PathVariable Long userPaymentMethodId) {
        return convertToResource(userPaymentMethodService.getUserPaymentMethodById(userPaymentMethodId));
    }

    @Operation(summary = "Create a OwnerPayment", description = "Create a OwnerPayment", tags = {"ownerPayments"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OwnerPayment created", content = @Content(mediaType = "application/json"))

    })
    @PostMapping("/ownerPayments/{ownerPaymentId}")
    public OwnerPaymentResource createUserPaymentMethod(@Valid @RequestBody SaveOwnerPaymentResource resource) {
        OwnerPayment userPaymentMethod = convertToEntity(resource);
        return convertToResource(userPaymentMethodService.createUserPaymentMethod(userPaymentMethod));
    }

    @Operation(summary = "Update a OwnerPayment", description = "Update a OwnerPayment", tags = {"ownerPayments"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OwnerPayment updated", content = @Content(mediaType = "application/json"))

    })
    @PutMapping("/ownerPayment/{ownerPaymentId}")
    public OwnerPaymentResource updateUserPaymentMethod(@PathVariable Long userPaymentMethodId, @Valid @RequestBody SaveOwnerPaymentResource resource) {
        OwnerPayment userPaymentMethod = convertToEntity(resource);
        return convertToResource(userPaymentMethodService.updateUserPaymentMethod(userPaymentMethodId, userPaymentMethod));
    }

    @Operation(summary = "Delete a OwnerPayment", description = "Delete a OwnerPayment", tags = {"ownerPayments"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OwnerPayment deleted", content = @Content(mediaType = "application/json"))

    })
    @DeleteMapping("/ownerPayment/{ownerPaymentId}")
    public ResponseEntity<?> deleteUserPaymentMethod(@PathVariable Long userPaymentMethodId) {
        return userPaymentMethodService.deleteUserPaymentMethod(userPaymentMethodId);
    }

    private OwnerPayment convertToEntity(SaveOwnerPaymentResource resource) {
        return mapper.map(resource, OwnerPayment.class);
    }

    private OwnerPaymentResource convertToResource(OwnerPayment entity) {
        return mapper.map(entity, OwnerPaymentResource.class);
    }
}
