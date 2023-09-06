package com.apiculture.main.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.apiculture.main.dao.ClientDao;
import com.apiculture.main.model.Client;
import com.apiculture.main.repository.ClientRepository;

@Repository
public class ClientDaoImpl implements ClientDao {

  @Autowired
  ClientRepository clientRepository;

  @Override
  public Client create(Client client) {
    return clientRepository.save(client);
  }

  @Override
  public List<Client> findAll() {
    return clientRepository.findAll();
  }

  @Override
  public Optional<Client> findById(Long id) {
    return clientRepository.findById(id);
  }

  @Override
  public Client update(Long id, Client client) {
    client.setId(id);
    return clientRepository.save(client);
  }

  @Override
  public int delete(Long id) {
    try {
      clientRepository.deleteById(id);
      return 0; // Éxito
    } catch (EmptyResultDataAccessException e) {
      return 1; // No se encontró un registro con el ID especificado
    } catch (Exception ex) {
      return -1; // Ocurrió un error inesperado
    }
  }

}
