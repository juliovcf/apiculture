package com.apiculture.main.service.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiculture.main.dao.UserDao;
import com.apiculture.main.exception.GenericException;
import com.apiculture.main.model.Role;
import com.apiculture.main.model.User;
import com.apiculture.main.service.UserService;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  UserDao dao;

  @Override
  public User create(User user) throws GenericException {
    try {
      return dao.create(user);
    } catch (Exception e) {
      throw new GenericException(e.getMessage(), e, 400);
    }
  }

  @Override
  public List<User> findAll() throws GenericException {
    try {
      return dao.findAll();
    } catch (Exception e) {
      throw new GenericException(e.getMessage(), e, 400);
    }
  }

  @Override
  public Optional<User> findById(Long id) throws GenericException {
    try {
      return dao.findById(id);
    } catch (Exception e) {
      throw new GenericException(e.getMessage(), e, 400);
    }
  }

  @Override
  public User update(Long id, User user) throws GenericException {
    try {
      return dao.update(id, user);
    } catch (EntityNotFoundException e) {
      throw new GenericException("El cliente con ID " + id + " no existe.", e, 400);
    } catch (Exception e) {
      throw new GenericException(e.getMessage(), e, 400);
    }
  }

  @Override
  public int delete(Long id) throws GenericException {
    try {
      return dao.delete(id);
    } catch (EntityNotFoundException e) {
      throw new GenericException("El cliente con ID " + id + " no existe.", e, 400);
    } catch (Exception e) {
      throw new GenericException(e.getMessage(), e, 500);
    }
  }

  @Override
  public List<User> findByRole(Role role) throws GenericException {
    try {
      return dao.findByRole(role);
    } catch (EntityNotFoundException e) {
      throw new GenericException("No existen usuarios con " + role, e, 400);
    } catch (Exception e) {
      throw new GenericException(e.getMessage(), e, 500);
    }
  }

}
