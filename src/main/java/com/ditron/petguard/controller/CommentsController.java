package com.ditron.petguard.controller;

import com.ditron.petguard.domain.model.Comment;
import com.ditron.petguard.domain.service.CommentService;
import com.ditron.petguard.domain.service.OwnerService;
import com.ditron.petguard.resource.CommentResource;
import com.ditron.petguard.resource.SaveCommentResource;
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
public class CommentsController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private CommentService commentService;
    @Autowired
    private OwnerService ownerService;

    @Operation(summary = "Get Comments", description = "Get All Comments by Page", tags = {"comments"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All Comments returned", content = @Content(mediaType = "application/json"))

    })
    @GetMapping("/comments")
    public Page<CommentResource> getAllComment(Pageable pageable) {
        Page<Comment> commentPage = commentService.getAllComments(pageable);
        List<CommentResource> resources = commentPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());

        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary = "Get Comment By ID", description = "Get Comment by ID", tags = {"comments"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Comment returned", content = @Content(mediaType = "application/json"))

    })
    @GetMapping("/comments/{commentId}")
    public CommentResource getCommentById(@PathVariable Long commentId) {
        return convertToResource(commentService.getCommentById(commentId));
    }

    @Operation(summary = "Get Comment By Comment ID and Owner ID", description = "Get Comment by Comment ID and Owner ID", tags = {"comments"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Comment and User returned", content = @Content(mediaType = "application/json"))

    })
    @GetMapping("/owners/{ownerId}/comments/{commentId}")
    public CommentResource getCommentByIdAndUserId(@PathVariable Long ownerId, @PathVariable Long commentId) {
        return convertToResource(commentService.getCommentByIdAndUserId(commentId,ownerId));
    }

    @Operation(summary = "Create a Comment", description = "Create a Comment", tags = {"comments"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Comment created", content = @Content(mediaType = "application/json"))

    })
    @PostMapping("/owners/{ownerId}/comments")
    public CommentResource createComment(@PathVariable Long ownerId, @Valid @RequestBody SaveCommentResource resource) {

        return convertToResource(commentService.createComment(ownerId,convertToEntity(resource)));
    }

    @Operation(summary = "Update a Comment", description = "Update a Comment", tags = {"comments"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Comment updated", content = @Content(mediaType = "application/json"))

    })
    @PutMapping("/comments/{commentId}")
    public CommentResource updateComment(@PathVariable Long commentId, @Valid @RequestBody SaveCommentResource resource) {
        Comment comment = convertToEntity(resource);
        return convertToResource(commentService.updateComment(commentId, comment));
    }

    @Operation(summary = "Delete a Comment", description = "Delete a Comment", tags = {"comments"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Comment deleted", content = @Content(mediaType = "application/json"))

    })
    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable Long commentId) {
        return commentService.deleteComment(commentId);
    }

    private Comment convertToEntity(SaveCommentResource resource) {
        return mapper.map(resource, Comment.class);
    }

    private CommentResource convertToResource(Comment entity) {
        return mapper.map(entity, CommentResource.class);
    }
}
