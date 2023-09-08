package com.apiculture.main.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.apiculture.main.controller.UserController;
import com.apiculture.main.exception.GenericException;
import com.apiculture.main.model.Role;
import com.apiculture.main.model.User;
import com.apiculture.main.service.UserService;
import com.apiculture.main.utils.ResponseObject;
import com.apiculture.main.utils.ResponseUtils;

public class UserControllerImpl  implements UserController{

  @Autowired
  UserService service;

  @Override
  public ResponseEntity<ResponseObject> create(User user) {
    ResponseEntity<ResponseObject> responseEntity;

    try {
      responseEntity = ResponseUtils.getResponseEntity(service.create(user));
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
  public ResponseEntity<ResponseObject> update(Long id, User user) {
    ResponseEntity<ResponseObject> responseEntity;

    try {
      responseEntity = ResponseUtils.getResponseEntity(service.update(id, user));
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
  public ResponseEntity<ResponseObject> getByRole(Role role) {
    ResponseEntity<ResponseObject> responseEntity;

    try {
      responseEntity = ResponseUtils.getResponseEntity(service.findByRole(role));
    } catch (GenericException e) {
      responseEntity = ResponseUtils.getResponseEntity(e);
    }

    return responseEntity;
  }


}
