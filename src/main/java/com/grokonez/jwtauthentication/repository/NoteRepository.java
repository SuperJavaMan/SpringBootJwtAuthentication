package com.grokonez.jwtauthentication.repository;

import com.grokonez.jwtauthentication.model.Note;
import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository<Note, Integer> {
}
