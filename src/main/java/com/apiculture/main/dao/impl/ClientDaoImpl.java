package com.apiculture.main.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.apiculture.main.dao.ClientDao;
import com.apiculture.main.model.Client;
import com.apiculture.main.model.Status;
import com.apiculture.main.repository.ClientRepository;

@Repository
public class ClientDaoImpl implements ClientDao {

  @Autowired
  ClientRepository repository;

  @SuppressWarnings("null")
  @Override
  public Client create(Client client) {
    return repository.save(client);
  }

  @Override
  public List<Client> findAll() {
    return repository.findAll();
  }

  @Override
  public Optional<Client> findById(int id) {
    return repository.findById(id);
  }

  @Override
  public Client update(int id, Client client) {
    client.setId(id);
    return repository.save(client);
  }

  @Override
  public int delete(int id) {
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
  public List<Client> findByStatus(Status status) {
    return repository.findByStatus(status);
  }

}
