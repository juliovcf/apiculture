package com.apiculture.main.service;

import java.util.List;
import java.util.Optional;

import com.apiculture.main.model.Client;

public interface ClientService {

  Client create (Client client);

  List<Client> findAll();

  Optional<Client> findById(Long id);

  Client update(Long id, Client client);

  int delete(Long id);

}
