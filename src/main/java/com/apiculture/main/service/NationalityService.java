package com.apiculture.main.service;

import java.util.List;
import java.util.Optional;

import com.apiculture.main.exception.GenericException;
import com.apiculture.main.model.Nationality;

public interface NationalityService {

  List<Nationality> findAll() throws GenericException;

  Optional<Nationality> findById(int id) throws GenericException;


}
