package com.apiculture.main.dao;

import java.util.List;
import java.util.Optional;

import com.apiculture.main.model.Client;
import com.apiculture.main.model.Status;

public interface ClientDao {

  Client create(Client client);

  List<Client> findAll();

  Optional<Client> findById(Long id);

  Client update(Long id, Client client);

  int delete(Long id);

  List<Client> findByStatus(Status status);

}
