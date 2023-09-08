package com.apiculture.main.service;

import java.util.List;
import java.util.Optional;

import com.apiculture.main.exception.GenericException;
import com.apiculture.main.model.Client;
import com.apiculture.main.model.Status;

public interface ClientService {

  Client create(Client client) throws GenericException;

  List<Client> findAll() throws GenericException;

  Optional<Client> findById(int id) throws GenericException;

  Client update(int id, Client client) throws GenericException;

  int delete(int id) throws GenericException;

  List<Client> findByStatus(Status status) throws GenericException;

}
