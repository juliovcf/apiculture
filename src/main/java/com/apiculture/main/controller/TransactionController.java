package com.apiculture.main.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.apiculture.main.model.Client;
import com.apiculture.main.model.Transaction;
import com.apiculture.main.utils.ResponseObject;

import io.swagger.v3.oas.annotations.Operation;

@RequestMapping("/transactions")
public interface TransactionController {

  @Operation(summary = "Create a Transaction", description = "Create a Transaction object passing that object as the request body. The expected response inside data object is a Transaction object.")
  @PostMapping
  ResponseEntity<ResponseObject> create(@RequestBody Transaction transaction);

  @Operation(summary = "Retrieve a Transaction by id", description = "Get a Transaction object by specifying its id. The expected response inside data object is a Transaction object.")
  @GetMapping("/{id}")
  ResponseEntity<ResponseObject> get(@PathVariable(required = true) Long id);

  @Operation(summary = "Retrieve all Transactions", description = "Get all Transaction objects. The expected response inside data object is a Transaction list.")
  @GetMapping
  ResponseEntity<ResponseObject> get();

  @Operation(summary = "Update a Transaction", description = "Update a Transaction object passing that object as the request body and its id as a parameter. The expected response inside data object is a Transaction object.")
  @PutMapping(value = "/{id}")
  ResponseEntity<ResponseObject> update(@PathVariable(required = true) Long id, @RequestBody Transaction transaction);

  @Operation(summary = "Delete a Transaction", description = "Delete a Transaction object by specifying its id. The expected response is a message.")
  @DeleteMapping(value = "/{id}")
  ResponseEntity<ResponseObject> delete(@PathVariable(required = true) Long id);

  @Operation(summary = "Retrieve all Transactions by Client", description = "Get all Transaction objects by specifying its Client. The expected response inside data object is a Transaction list.")
  @PostMapping(value = "/client")
  ResponseEntity<ResponseObject> getByClient(@RequestBody(required = true) Client client);

}
