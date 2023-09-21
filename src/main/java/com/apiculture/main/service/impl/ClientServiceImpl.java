package com.apiculture.main.service.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.apiculture.main.dao.ClientDao;
import com.apiculture.main.exception.GenericException;
import com.apiculture.main.model.Client;
import com.apiculture.main.model.Status;
import com.apiculture.main.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

  @Autowired
  ClientDao dao;

  @Override
  public Client create(Client client) throws GenericException {
    try {
      return dao.create(client);
    } catch (DataIntegrityViolationException e) {
      throw new GenericException("Los datos introducidos son incorrectos", e, 400);
    } catch (Exception e) {
      throw new GenericException(e.getMessage(), e, 500);
    }
  }

  @Override
  public List<Client> findAll() throws GenericException {
    try {
      return dao.findAll();
    } catch (Exception e) {
      throw new GenericException(e.getMessage(), e, 400);
    }
  }

  @Override
  public Optional<Client> findById(int id) throws GenericException {
    try {
      return dao.findById(id);
    } catch (EntityNotFoundException e) {
      throw new GenericException("El cliente con ID " + id + " no existe.", e, 400);
    } catch (Exception e) {
      throw new GenericException(e.getMessage(), e, 400);
    }
  }

  @Override
  public Client update(int id, Client client) throws GenericException {
    try {
      return dao.update(id, client);
    } catch (EntityNotFoundException e) {
      throw new GenericException("El cliente con ID " + id + " no existe.", e, 400);
    } catch (Exception e) {
      throw new GenericException(e.getMessage(), e, 500);
    }
  }

  @Override
  public int delete(int id) throws GenericException {
    try {
      return dao.delete(id);
    } catch (EntityNotFoundException e) {
      throw new GenericException("El cliente con ID " + id + " no existe.", e, 400);
    } catch (Exception e) {
      throw new GenericException(e.getMessage(), e, 500);
    }
  }

  @Override
  public List<Client> findByStatus(Status status) throws GenericException {
    try {
      return dao.findByStatus(status);
    } catch (EntityNotFoundException e) {
      throw new GenericException("No existen usuarios con " + status, e, 400);
    } catch (Exception e) {
      throw new GenericException(e.getMessage(), e, 500);
    }
  }
}
