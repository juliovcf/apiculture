package com.apiculture.main.service;

import java.util.List;
import java.util.Optional;

import com.apiculture.main.exception.GenericException;
import com.apiculture.main.model.Status;

public interface StatusService {

  Status create(Status status) throws GenericException;

  List<Status> findAll() throws GenericException;

  Optional<Status> findById(int id) throws GenericException;

  Status update(int id, Status status) throws GenericException;

  int delete(int id) throws GenericException;

}
