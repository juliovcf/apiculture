package com.apiculture.main.dao;

import java.util.List;
import java.util.Optional;

import com.apiculture.main.model.Client;
import com.apiculture.main.model.Note;
import com.apiculture.main.model.Status;

public interface NoteDao {

  Note create(Note note);

  List<Note> findAll();

  Optional<Note> findById(Long id);

  Note update(Long id, Note note);

  int delete(Long id);

  List<Note> findByStatus(Status status);

  List<Note> findByClient(Client client);

}
