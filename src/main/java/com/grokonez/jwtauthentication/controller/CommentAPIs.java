package com.grokonez.jwtauthentication.controller;

import com.grokonez.jwtauthentication.exceptions.ResourceNotFoundException;
import com.grokonez.jwtauthentication.model.Comment;
import com.grokonez.jwtauthentication.repository.CommentRepository;
import com.grokonez.jwtauthentication.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")
public class CommentAPIs {

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping("note/{noteId}/comments")
    public Page<Comment> getAllCommentsByNoteId(@PathVariable(value = "noteId") Long noteId,
                                                Pageable pageable) {
        return commentRepository.findByNoteId(noteId, pageable);
    }

    @PostMapping("note/{noteId}/comments")
    public Comment createComment(@PathVariable(value = "noteId") Long noteId,
                                 @Valid @RequestBody Comment comment) {
        return noteRepository.findById(noteId).map(note -> {
            comment.setNote(note);
            return commentRepository.save(comment);
        }).orElseThrow(() -> new ResourceNotFoundException("Note by Id " + noteId + " not found"));
    }

    @PostMapping("note/{noteId}/comments/{commentId}")
    public Comment updateComment(@PathVariable(value = "noteId") Long noteId,
                                 @PathVariable(value = "commentId") Long commentId,
                                 @Valid @RequestBody Comment commentReqquest) {
        if(!noteRepository.existsById(noteId)) {
            throw new ResourceNotFoundException("Note by Id " + noteId + " not found");
        }
        return commentRepository.findById(commentId).map(comment -> {
            comment.setText(commentReqquest.getText());
            return commentRepository.save(comment);
        }).orElseThrow(() -> new ResourceNotFoundException("Comment by Id " + commentId + " not found"));
    }
    @DeleteMapping("note/{noteId}/comments/{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable(value = "noteId") Long noteId,
                                           @PathVariable(value = "commentId") Long commentId) {
        return commentRepository.findByIdAndNoteId(noteId, commentId).map(comment -> {
            commentRepository.delete(comment);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Comment by Id " + commentId + " not found"));
    }
}

