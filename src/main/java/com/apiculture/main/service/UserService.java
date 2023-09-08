package com.apiculture.main.service;

import java.util.List;
import java.util.Optional;

import com.apiculture.main.exception.GenericException;
import com.apiculture.main.model.Role;
import com.apiculture.main.model.User;

public interface UserService {

  User create(User user) throws GenericException;

  List<User> findAll() throws GenericException;

  Optional<User> findById(int id) throws GenericException;

  User update(int id, User user) throws GenericException;

  int delete(int id) throws GenericException;

  List<User> findByRole(Role role) throws GenericException;

}
