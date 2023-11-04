package com.apiculture.main.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.apiculture.main.utils.ResponseObject;

@RequestMapping("/nationalities")
public interface NationalityController {

  @GetMapping()
  ResponseEntity<ResponseObject> get();

  @GetMapping("/{id}")
  ResponseEntity<ResponseObject> get(int id);

}
