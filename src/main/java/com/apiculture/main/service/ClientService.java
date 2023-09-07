package com.apiculture.main.service;

import java.util.List;
import java.util.Optional;

import com.apiculture.main.exception.GenericException;
import com.apiculture.main.model.Client;

public interface ClientService {

  Client create (Client client) throws GenericException;

  List<Client> findAll() throws GenericException;

  Optional<Client> findById(Long id) throws GenericException;

  Client update(Long id, Client client) throws GenericException;

  int delete(Long id) throws GenericException;

}
