package com.apiculture.main.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.apiculture.main.dao.NoteDao;
import com.apiculture.main.model.Client;
import com.apiculture.main.model.Note;
import com.apiculture.main.model.Status;
import com.apiculture.main.repository.NoteRepository;

@Repository
public class NoteDaoImpl implements NoteDao {

  @Autowired
  NoteRepository repository;

  @Override
  public Note create(Note note) {
    return repository.save(note);
  }

  @Override
  public List<Note> findAll() {
    return repository.findAll();
  }

  @Override
  public Optional<Note> findById(Long id) {
    return repository.findById(id);
  }

  @Override
  public Note update(Long id, Note note) {
    note.setId(id);
    return repository.save(note);
  }

  @Override
  public int delete(Long id) {
    try {
      repository.deleteById(id);
      return 0; // Éxito
    } catch (EmptyResultDataAccessException e) {
      return 1; // No se encontró un registro con el ID especificado
    } catch (Exception e) {
      return -1; // Ocurrió un error inesperado
    }
  }

  @Override
  public List<Note> findByStatus(Status status) {
    return repository.findByStatus(status);
  }

  @Override
  public List<Note> findByClient(Client client){
    return repository.findByClient(client);
  }

}
