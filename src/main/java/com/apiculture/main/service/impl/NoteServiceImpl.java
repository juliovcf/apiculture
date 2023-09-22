package com.apiculture.main.service.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiculture.main.dao.NoteDao;
import com.apiculture.main.exception.GenericException;
import com.apiculture.main.model.Client;
import com.apiculture.main.model.Note;
import com.apiculture.main.model.Status;
import com.apiculture.main.service.NoteService;

@Service
public class NoteServiceImpl implements NoteService {

  @Autowired
  NoteDao dao;

  @Override
  public Note create(Note note) throws GenericException {
    try {
      return dao.create(note);
    } catch (Exception e) {
      throw new GenericException(e.getMessage(), e, 400);
    }
  }

  @Override
  public List<Note> findAll() throws GenericException {
    try {
      return dao.findAll();
    } catch (Exception e) {
      throw new GenericException(e.getMessage(), e, 400);
    }
  }

  @Override
  public Optional<Note> findById(Long id) throws GenericException {
    try {
      return dao.findById(id);
    } catch (Exception e) {
      throw new GenericException(e.getMessage(), e, 400);
    }
  }

  @Override
  public Note update(Long id, Note note) throws GenericException {
    try {
      return dao.update(id, note);
    } catch (Exception e) {
      throw new GenericException(e.getMessage(), e, 400);
    }
  }

  @Override
  public int delete(Long id) throws GenericException {
    try {
      return dao.delete(id);
    } catch (Exception e) {
      throw new GenericException(e.getMessage(), e, 400);
    }
  }

  @Override
  public List<Note> findByStatus(Status status) throws GenericException {
    try {
      return dao.findByStatus(status);
    } catch (Exception e) {
      throw new GenericException(e.getMessage(), e, 400);
    }
  }

  @Override
  public List<Note> findByClient(Client client) throws GenericException {
    try {
      return dao.findByClient(client);
    } catch (EntityNotFoundException e) {
      throw new GenericException("No existen notas para " + client, e, 400);
    } catch (Exception e) {
      throw new GenericException(e.getMessage(), e, 500);
    }
  }

  @Override
  public List<Note> findByClientAndStatus(Client client, Status status) throws GenericException {
    try {
      return dao.findByClientAndStatus(client, status);
    } catch (EntityNotFoundException e) {
      throw new GenericException("No existen notas para el cliente " + client + " con estado " + status, e, 404);
    } catch (Exception e) {
      throw new GenericException("Error al buscar notas por cliente y estado", e, 500);
    }
  }

}
