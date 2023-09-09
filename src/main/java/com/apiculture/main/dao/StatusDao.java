package com.apiculture.main.dao;

import java.util.List;
import java.util.Optional;

import com.apiculture.main.model.Status;

public interface StatusDao {

  Status create(Status status);

  List<Status> findAll();

  Optional<Status> findById(int id);

  Status update(int id, Status status);

  int delete(int id);

}
