package com.apiculture.main.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.apiculture.main.model.Role;
import com.apiculture.main.model.User;
import com.apiculture.main.utils.ResponseObject;

import io.swagger.v3.oas.annotations.Operation;

@RequestMapping("/users")
public interface UserController {

  @Operation(summary = "Create a User", description = "Create a User object passing that object as the request body. The expected response inside data object is a User object.")
  @PostMapping
  ResponseEntity<ResponseObject> create(@RequestBody User user);

  @Operation(summary = "Retrieve a User by id", description = "Get a User object by specifying its id. The expected response inside data object is a User object.")
  @GetMapping("/{id}")
  ResponseEntity<ResponseObject> get(@PathVariable int id);

  @Operation(summary = "Retrieve all Users", description = "Get all User objects. The expected response inside data object is a User list.")
  @GetMapping
  ResponseEntity<ResponseObject> get();

  @Operation(summary = "Update a User", description = "Update a User object passing that object as the request body and its id as a parameter. The expected response inside data object is a User object.")
  @PutMapping(value = "/{id}")
  ResponseEntity<ResponseObject> update(@PathVariable(required = true) int id, @RequestBody User user);

  @Operation(summary = "Delete a User", description = "Delete a User object by specifying its id. The expected response is a message.")
  @DeleteMapping(value = "/{id}")
  ResponseEntity<ResponseObject> delete(@PathVariable(required = true) int id);

  @Operation(summary = "Retrieve all Users by Role", description = "Get all User objects by specifying its Role. The expected response inside data object is a User list.")
  @PostMapping(value = "/role")
  ResponseEntity<ResponseObject> getByRole(@RequestBody Role role);

}
