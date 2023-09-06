package com.apiculture.main.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

import com.apiculture.main.dao.UserDao;
import com.apiculture.main.model.User;
import com.apiculture.main.repository.UserRepository;

public class UserDaoImpl implements UserDao {

  @Autowired
  UserRepository userRepository;

  @Override
  public User create(User user) {
    return userRepository.save(user);
  }

  @Override
  public List<User> findAll() {
    return userRepository.findAll();
  }

  @Override
  public Optional<User> findById(Long id) {
    return userRepository.findById(id);
  }

  @Override
  public User update(Long id, User user) {
    user.setId(id);
    return userRepository.save(user);
  }

  @Override
  public int delete(Long id) {
    try {
      userRepository.deleteById(id);
      return 0; // Éxito
    } catch (EmptyResultDataAccessException e) {
      return 1; // No se encontró un registro con el ID especificado
    } catch (Exception ex) {
      return -1; // Ocurrió un error inesperado
    }
  }

}
