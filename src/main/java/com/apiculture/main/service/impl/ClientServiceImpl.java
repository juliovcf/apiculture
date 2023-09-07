package com.apiculture.main.service.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiculture.main.dao.ClientDao;
import com.apiculture.main.exception.GenericException;
import com.apiculture.main.model.Client;
import com.apiculture.main.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

  @Autowired
  ClientDao clientDao;

  @Override
  public Client create(Client client) throws GenericException {
    try {
      return clientDao.create(client);
    } catch (Exception e) {
      throw new GenericException(e.getMessage(), e, 400);
    }
  }

  @Override
  public List<Client> findAll() throws GenericException {
    try {
      return clientDao.findAll();
    } catch (Exception e) {
      throw new GenericException(e.getMessage(), e, 400);
    }
  }

  @Override
  public Optional<Client> findById(Long id) throws GenericException {
    try {
      return clientDao.findById(id);
    } catch (Exception e) {
      throw new GenericException(e.getMessage(), e, 400);
    }

  }

  @Override
  public Client update(Long id, Client client) throws GenericException {
    try {
      return clientDao.update(id, client);
    } catch (EntityNotFoundException e) {
      throw new GenericException("El cliente con ID " + id + " no existe.", e, 400);
    } catch (Exception e) {
      throw new GenericException(e.getMessage(), e, 500);
    }
  }

  @Override
  public int delete(Long id) throws GenericException {
    try {
      return clientDao.delete(id);
    } catch (EntityNotFoundException e) {
      throw new GenericException("El cliente con ID " + id + " no existe.", e, 400);
    } catch (Exception e) {
      throw new GenericException(e.getMessage(), e, 500);
    }

  }

}
