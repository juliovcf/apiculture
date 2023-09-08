package com.apiculture.main.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.apiculture.main.dao.UserDao;
import com.apiculture.main.model.Role;
import com.apiculture.main.model.User;
import com.apiculture.main.repository.UserRepository;

@Repository
public class UserDaoImpl implements UserDao {

  @Autowired
  UserRepository repository;

  @Override
  public User create(User user) {
    return repository.save(user);
  }

  @Override
  public List<User> findAll() {
    return repository.findAll();
  }

  @Override
  public Optional<User> findById(int id) {
    return repository.findById(id);
  }

  @Override
  public User update(int id, User user) {
    user.setId(id);
    return repository.save(user);
  }

  @Override
  public int delete(int id) {
    try {
      repository.deleteById(id);
      return 0; // Éxito
    } catch (EmptyResultDataAccessException e) {
      return 1; // No se encontró un registro con el ID especificado
    } catch (Exception ex) {
      return -1; // Ocurrió un error inesperado
    }
  }

  @Override
  public List<User> findByRole(Role role) {
    return repository.findByRole(role);
  }
}
