package com.grokonez.jwtauthentication.controller;

import com.grokonez.jwtauthentication.model.Note;
import com.grokonez.jwtauthentication.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class NoteRestAPIs {

    @Autowired
    private NoteRepository noteRepository;

    @GetMapping("/notes")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<Note> getNotes() {
        return (List<Note>) noteRepository.findAll();
    }

    @GetMapping("/notes/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public Note getNoteById(@PathVariable int id) {
        return noteRepository.findById(id).get();
    }

    @PostMapping("/notes")
    @PreAuthorize("hasRole('ADMIN')")
    public Note addNote(@RequestBody Note note) {
        return noteRepository.save(note);
    }

    @PutMapping("/notes/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Note updateNote(@PathVariable int id,
                           @RequestBody Note requestNote) {
        Note updatedNote = noteRepository.findById(id).get();
        updatedNote.setTitle(requestNote.getTitle());
        updatedNote.setBody(requestNote.getBody());
        return noteRepository.save(updatedNote);
    }
    @DeleteMapping("/notes/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteNote(@PathVariable int id) {
        Note deletedNote = noteRepository.findById(id).get();
        noteRepository.delete(deletedNote);
    }
}
