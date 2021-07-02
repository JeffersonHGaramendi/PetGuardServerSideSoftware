package com.ditron.petguard.domain.service;

import com.ditron.petguard.domain.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;


public interface CommentService {
    Page<Comment> getAllComments(Pageable pageable);

    Comment getCommentById(Long commentId);

    Comment getCommentByIdAndUserId(Long commentId,Long userId);

    Comment createComment(Long ownerId,Comment comment);

    Comment updateComment(Long commentId, Comment commentDetails);

    ResponseEntity<?> deleteComment(Long commentId);
}
