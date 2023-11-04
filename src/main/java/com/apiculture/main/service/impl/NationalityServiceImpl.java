package com.apiculture.main.service.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiculture.main.exception.GenericException;
import com.apiculture.main.model.Nationality;
import com.apiculture.main.repository.NationalityRepository;
import com.apiculture.main.service.NationalityService;

@Service
public class NationalityServiceImpl implements NationalityService {

  @Autowired
  NationalityRepository repository;

  @Override
  public List<Nationality> findAll() throws GenericException {
    try {
      return repository.findAll();
    } catch (Exception e) {
      throw new GenericException(e.getMessage(), e, 400);
    }
  }

  @Override
  public Optional<Nationality> findById(int id) throws GenericException {
    try {
      return repository.findById(id);
    } catch (EntityNotFoundException e) {
      throw new GenericException("El status con ID " + id + " no existe.", e, 400);
    }  catch (Exception e) {
      throw new GenericException(e.getMessage(), e, 400);
    }
  }

}
