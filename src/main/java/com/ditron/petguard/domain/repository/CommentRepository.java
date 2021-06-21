package com.ditron.petguard.domain.repository;
import com.ditron.petguard.domain.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
    Page<Comment> findByUserId(Long postId, Pageable pageable);
    Optional<Comment> findByIdAndUserId(Long id, Long userId);
}
