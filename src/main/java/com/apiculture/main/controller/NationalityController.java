package com.apiculture.main.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.apiculture.main.utils.ResponseObject;

import io.swagger.v3.oas.annotations.Operation;

@RequestMapping("/nationalities")
public interface NationalityController {

  @Operation(summary = "Retrieve all Nationalities", description = "The expected response inside data object is a Nationality list.")
  @GetMapping()
  ResponseEntity<ResponseObject> get();

  @Operation(summary = "Retrieve a Nationality by ID")
  @GetMapping("/{id}")
  ResponseEntity<ResponseObject> get(int id);

}
