package com.apiculture.main.dao;

import java.util.List;
import java.util.Optional;

import com.apiculture.main.model.Client;
import com.apiculture.main.model.Status;

public interface ClientDao {

  Client create(Client client);

  List<Client> findAll();

  Optional<Client> findById(int id);

  Client update(int id, Client client);

  int delete(int id);

  List<Client> findByStatus(Status status);

}
