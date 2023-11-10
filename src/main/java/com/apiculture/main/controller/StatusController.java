package com.apiculture.main.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.apiculture.main.model.Status;
import com.apiculture.main.utils.ResponseObject;

import io.swagger.v3.oas.annotations.Operation;

@RequestMapping("/status")
public interface StatusController {

  @Operation(summary = "Create a Status", description = "Create a Status object passing that object as the request body. The expected response inside data object is a Status object.")
  @PostMapping
  ResponseEntity<ResponseObject> create(@RequestBody Status status);

  @Operation(summary = "Retrieve a Status by id", description = "Get a Status object by specifying its id. The expected response inside data object is a Status object.")
  @GetMapping("/{id}")
  ResponseEntity<ResponseObject> get(@PathVariable int id);

  @Operation(summary = "Retrieve all Status", description = "Get all Status objects. The expected response inside data object is a Status list.")
  @GetMapping()
  ResponseEntity<ResponseObject> get();

  @Operation(summary = "Update a Status", description = "Update a Status object passing that object as the request body and its id as a parameter. The expected response inside data object is a Status object.")
  @PutMapping(value = "/{id}")
  ResponseEntity<ResponseObject> update(@PathVariable(required = true) int id, @RequestBody Status status);

  @Operation(summary = "Delete a Status", description = "Delete a Status object by specifying its id. The expected response is a message.")
  @DeleteMapping(value = "/{id}")
  ResponseEntity<ResponseObject> delete(@PathVariable(required = true) int id);

}
