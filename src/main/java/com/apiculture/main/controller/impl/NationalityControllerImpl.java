package com.apiculture.main.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.apiculture.main.controller.NationalityController;
import com.apiculture.main.exception.GenericException;
import com.apiculture.main.service.NationalityService;
import com.apiculture.main.utils.ResponseObject;
import com.apiculture.main.utils.ResponseUtils;

@CrossOrigin
@RestController
public class NationalityControllerImpl implements NationalityController{

  @Autowired
  private NationalityService service;

  @Override
  public ResponseEntity<ResponseObject> get() {
    ResponseEntity<ResponseObject> responseEntity;

    try {
      responseEntity = ResponseUtils.getResponseEntity(service.findAll());
    } catch (GenericException e) {
      responseEntity = ResponseUtils.getResponseEntity(e);
    }

    return responseEntity;
  }

  @Override
  public ResponseEntity<ResponseObject> get(int id) {
    ResponseEntity<ResponseObject> responseEntity;

    try {
      responseEntity = ResponseUtils.getResponseEntity(service.findById(id));
    } catch (GenericException e) {
      responseEntity = ResponseUtils.getResponseEntity(e);
    }

    return responseEntity;
  }


}
