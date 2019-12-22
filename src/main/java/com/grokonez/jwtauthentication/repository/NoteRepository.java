package com.grokonez.jwtauthentication.repository;

import com.grokonez.jwtauthentication.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
