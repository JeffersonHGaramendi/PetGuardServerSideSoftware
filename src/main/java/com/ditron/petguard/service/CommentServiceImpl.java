package com.ditron.petguard.service;

import com.ditron.petguard.domain.model.Comment;
import com.ditron.petguard.domain.repository.CommentRepository;
import com.ditron.petguard.domain.repository.OwnerRepository;
import com.ditron.petguard.domain.service.CommentService;
import com.ditron.petguard.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private OwnerRepository ownerRepository;

    @Override
    public Page<Comment> getAllComments(Pageable pageable) {
        return commentRepository.findAll(pageable);
    }

    @Override
    public Comment getCommentById(Long commentId) {
        return commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment", "Id", commentId));
    }

    @Override
    public Comment getCommentByIdAndUserId(Long userId, Long commentId) {
        return commentRepository.findByIdAndOwnerId(commentId, userId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Comment not found with Id" + commentId +
                                " and UserId " + userId));
    }

    @Override
    public Comment createComment(Long ownerId,Comment comment) {

        return ownerRepository.findById(ownerId).map(owner -> {
            comment.setOwner(owner);
            return commentRepository.save(comment);
        }).orElseThrow(() -> new ResourceNotFoundException(
                "Owner", "Id", ownerId));
    }

    @Override
    public Comment updateComment(Long commentId, Comment commentRequest) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment", "Id", commentId));
        return commentRepository.save(
                comment.setDescription(commentRequest.getDescription()));
    }

    @Override
    public ResponseEntity<?> deleteComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment", "Id", commentId));
        commentRepository.delete(comment);
        return ResponseEntity.ok().build();
    }
}
