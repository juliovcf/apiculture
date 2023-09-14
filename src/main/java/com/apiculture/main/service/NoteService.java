package com.apiculture.main.service;

import java.util.List;
import java.util.Optional;

import com.apiculture.main.exception.GenericException;
import com.apiculture.main.model.Client;
import com.apiculture.main.model.Note;
import com.apiculture.main.model.Status;

public interface NoteService {

  Note create(Note note) throws GenericException;

  List<Note> findAll() throws GenericException;

  Optional<Note> findById(Long id) throws GenericException;

  Note update(Long id, Note note) throws GenericException;

  int delete(Long id) throws GenericException;

  List<Note> findByStatus(Status status) throws GenericException;

  List<Note> findByClient(Client client) throws GenericException;

}
