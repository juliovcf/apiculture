package com.apiculture.main.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

import com.apiculture.main.dao.ClientDao;
import com.apiculture.main.model.Client;
import com.apiculture.main.service.ClientService;

public class ClientServiceImpl implements ClientService {

  @Autowired
  ClientDao clientDao;

  @Override
  public Client create(Client client) {
    return clientDao.create(client);
  }

  @Override
  public List<Client> findAll() {
    return clientDao.findAll();
  }

  @Override
  public Optional<Client> findById(Long id) {
    return clientDao.findById(id);
  }

  @Override
  public Client update(Long id, Client client) {
    return clientDao.update(id, client);
  }

  @Override
  public int delete(Long id) {
    try {
      clientDao.delete(id);
      return 0; // Éxito
    } catch (EmptyResultDataAccessException e) {
      return 1; // No se encontró un registro con el ID especificado
    } catch (Exception ex) {
      return -1; // Ocurrió un error inesperado
    }
  }

}
