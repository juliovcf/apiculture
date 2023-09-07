package com.apiculture.main.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.apiculture.main.exception.GenericException;

public class ResponseUtils {

  private ResponseUtils() {

  }

  public static <T> ResponseEntity<ResponseObject> getResponseEntity(T t) {
    return getResponseEntityObject(ResponseObject.create(200, t));
  }

  public static ResponseEntity<ResponseObject> getResponseEntity(GenericException ge) {
    return getResponseEntityObject(ResponseObject.create(ge.getCode(), ge.getLocalizedMessage()));
  }

  private static ResponseEntity<ResponseObject> getResponseEntityObject(ResponseObject responseObject) {
    return ResponseEntity.status(HttpStatus.valueOf(responseObject.getMetadata().getStatus())).body(responseObject);
  }

}
