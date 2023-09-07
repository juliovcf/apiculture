package com.apiculture.main.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.apiculture.main.controller.ClientController;
import com.apiculture.main.exception.GenericException;
import com.apiculture.main.model.Client;
import com.apiculture.main.service.ClientService;
import com.apiculture.main.utils.ResponseObject;
import com.apiculture.main.utils.ResponseUtils;

@RestController
public class ClientControllerImpl implements ClientController {

  @Autowired
  private ClientService service;

  @Override
  public ResponseEntity<ResponseObject> create(Client client) {
    ResponseEntity<ResponseObject> responseEntity;

    try {
      responseEntity = ResponseUtils.getResponseEntity(service.create(client));
    } catch (GenericException e) {
      responseEntity = ResponseUtils.getResponseEntity(e);
    }

    return responseEntity;
  }

  @Override
  public ResponseEntity<ResponseObject> get(Long id) {
    ResponseEntity<ResponseObject> responseEntity;

    try {
      responseEntity = ResponseUtils.getResponseEntity(service.findById(id));
    } catch (GenericException e) {
      responseEntity = ResponseUtils.getResponseEntity(e);
    }

    return responseEntity;
  }

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
  public ResponseEntity<ResponseObject> update(Long id, Client client) {
    ResponseEntity<ResponseObject> responseEntity;

    try {
      responseEntity = ResponseUtils.getResponseEntity(service.update(id, client));
    } catch (GenericException e) {
      responseEntity = ResponseUtils.getResponseEntity(e);
    }

    return responseEntity;
  }

  @Override
  public ResponseEntity<ResponseObject> delete(Long id) {
    ResponseEntity<ResponseObject> responseEntity;

    try {
      responseEntity = ResponseUtils.getResponseEntity(service.delete(id));
    } catch (GenericException e) {
      responseEntity = ResponseUtils.getResponseEntity(e);
    }

    return responseEntity;
  }

}
