package com.apiculture.main.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.apiculture.main.dao.StatusDao;
import com.apiculture.main.model.Status;
import com.apiculture.main.repository.StatusRepository;

@Repository
public class StatusDaoImpl implements StatusDao {

  @Autowired
  StatusRepository statusRepository;

  @SuppressWarnings("null")
  @Override
  public Status create(Status status) {
    return statusRepository.save(status);
  }

  @Override
  public List<Status> findAll() {
    return statusRepository.findAll();
  }

  @Override
  public Optional<Status> findById(int id) {
    return statusRepository.findById(id);
  }

  @Override
  public Status update(int id, Status status) {
    status.setId(id);
    return statusRepository.save(status);
  }

  @Override
  public int delete(int id) {
    try {
      statusRepository.deleteById(id);
      return 0; // Éxito
    } catch (EmptyResultDataAccessException e) {
      return 1; // No se encontró un registro con el ID especificado
    } catch (Exception ex) {
      return -1; // Ocurrió un error inesperado
    }
  }

}
