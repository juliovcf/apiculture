package com.apiculture.main.dao;

import java.util.List;
import java.util.Optional;

import com.apiculture.main.model.Role;
import com.apiculture.main.model.User;

public interface UserDao {

  User create(User user);

  List<User> findAll();

  Optional<User> findById(int id);

  User update(int id, User user);

  int delete(int id);

  List<User> findByRole(Role role);
}
