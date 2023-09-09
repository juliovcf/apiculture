package com.apiculture.main.service.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiculture.main.dao.StatusDao;
import com.apiculture.main.exception.GenericException;
import com.apiculture.main.model.Status;
import com.apiculture.main.service.StatusService;

@Service
public class StatusServiceImpl implements StatusService {

  @Autowired
  StatusDao dao;

  @Override
  public Status create(Status status) throws GenericException {
    try {
      return dao.create(status);
    } catch (Exception e) {
      throw new GenericException(e.getMessage(), e, 400);
    }
  }

  @Override
  public List<Status> findAll() throws GenericException {
    try {
      return dao.findAll();
    } catch (Exception e) {
      throw new GenericException(e.getMessage(), e, 400);
    }
  }

  @Override
  public Optional<Status> findById(int id) throws GenericException {
    try {
      return dao.findById(id);
    } catch (EntityNotFoundException e) {
      throw new GenericException("El status con ID " + id + " no existe.", e, 400);
    }  catch (Exception e) {
      throw new GenericException(e.getMessage(), e, 400);
    }
  }

  @Override
  public Status update(int id, Status status) throws GenericException {
    try {
      return dao.update(id, status);
    } catch (EntityNotFoundException e) {
      throw new GenericException("El status con ID " + id + " no existe.", e, 400);
    } catch (Exception e) {
      throw new GenericException(e.getMessage(), e, 400);
    }
  }

  @Override
  public int delete(int id) throws GenericException {
    try {
      return dao.delete(id);
    } catch (EntityNotFoundException e) {
      throw new GenericException("El cliente con ID " + id + " no existe.", e, 400);
    } catch (Exception e) {
      throw new GenericException(e.getMessage(), e, 500);
    }
  }

}
