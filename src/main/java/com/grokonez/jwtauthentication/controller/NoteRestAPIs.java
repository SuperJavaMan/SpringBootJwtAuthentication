package com.grokonez.jwtauthentication.controller;

import com.grokonez.jwtauthentication.exceptions.ResourceNotFoundException;
import com.grokonez.jwtauthentication.model.Note;
import com.grokonez.jwtauthentication.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

<<<<<<< HEAD
import java.util.Arrays;
import java.util.List;
=======
import javax.validation.Valid;
>>>>>>> origin/master

@CrossOrigin
@RestController
@RequestMapping("/api")
public class NoteRestAPIs {

    @Autowired
    private NoteRepository noteRepository;

    @GetMapping("/notes")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public Page<Note> getNotes(Pageable pageable) {
        return noteRepository.findAll(pageable);
    }

    @GetMapping("/notes/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public Note getNoteById(@PathVariable Long id) {
        return noteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Note by Id " + id + " not found"));
    }

    @PostMapping("/notes")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public Note addNote(@Valid @RequestBody Note note) {
        return noteRepository.save(note);
    }

    @PutMapping("/notes/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public Note updateNote(@PathVariable Long id,
                           @Valid @RequestBody Note requestNote) {
        return noteRepository.findById(id).map(note -> {
           note.setTitle(requestNote.getTitle());
           note.setBody(requestNote.getBody());
           return noteRepository.save(note);
        }).orElseThrow(() -> new ResourceNotFoundException("Note by Id " + id + " not found"));
    }
    @DeleteMapping("/notes/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> deleteNote(@PathVariable Long id) {
        return noteRepository.findById(id).map(note -> {
            noteRepository.delete(note);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Note by Id " + id + " not found"));
    }
}
