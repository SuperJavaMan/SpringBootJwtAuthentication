package com.grokonez.jwtauthentication.repository;

import com.grokonez.jwtauthentication.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Page<Comment> findByNoteId(Long id, Pageable pageable);
    Optional<Comment> findByIdAndNoteId(Long noteId, Long commentId);
}
