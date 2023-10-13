package com.apiculture.main.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.apiculture.main.controller.TransactionController;
import com.apiculture.main.exception.GenericException;
import com.apiculture.main.model.Client;
import com.apiculture.main.model.Transaction;
import com.apiculture.main.service.TransactionService;
import com.apiculture.main.utils.ResponseObject;
import com.apiculture.main.utils.ResponseUtils;

@RestController
@CrossOrigin
public class TransactionControllerImpl implements TransactionController {

  @Autowired
  private TransactionService service;

  @Override
  public ResponseEntity<ResponseObject> create(Transaction transaction) {
    ResponseEntity<ResponseObject> responseEntity;

    try {
      responseEntity = ResponseUtils.getResponseEntity(service.create(transaction));
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
  public ResponseEntity<ResponseObject> update(Long id, Transaction transaction) {
    ResponseEntity<ResponseObject> responseEntity;

    try {
      responseEntity = ResponseUtils.getResponseEntity(service.update(id, transaction));
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

  @Override
  public ResponseEntity<ResponseObject> getByClient(Client client) {
    ResponseEntity<ResponseObject> responseEntity;

    try {
      responseEntity = ResponseUtils.getResponseEntity(service.findByClient(client));
    } catch (GenericException e) {
      responseEntity = ResponseUtils.getResponseEntity(e);
    }

    return responseEntity;
  }

}
