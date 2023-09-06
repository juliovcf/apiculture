package com.apiculture.main.dao;

import java.util.List;
import java.util.Optional;

import com.apiculture.main.model.Status;

public interface StatusDao {

  Status create(Status status);

  List<Status> findAll();

  Optional<Status> findById(Short id);

  Status update(Short id, Status status);

  int delete(Short id);

}
