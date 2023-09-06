package com.apiculture.main.dao;

import java.util.List;
import java.util.Optional;

import com.apiculture.main.model.User;

public interface UserDao {

  User create(User user);

  List<User> findAll();

  Optional<User> findById(Long id);

  User update(Long id, User user);

  int delete(Long id);
}
