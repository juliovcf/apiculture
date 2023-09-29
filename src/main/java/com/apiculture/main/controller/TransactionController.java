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

@RequestMapping("/transactions")
public interface TransactionController {

  @PostMapping
  ResponseEntity<ResponseObject> create(@RequestBody Transaction transaction);

  @GetMapping("/{id}")
  ResponseEntity<ResponseObject> get(@PathVariable(required = true) Long id);

  @GetMapping
  ResponseEntity<ResponseObject> get();

  @PutMapping(value = "/{id}")
  ResponseEntity<ResponseObject> update(@PathVariable(required = true) Long id, @RequestBody Transaction transaction);

  @DeleteMapping(value = "/{id}")
  ResponseEntity<ResponseObject> delete(@PathVariable(required = true) Long id);

  @PostMapping(value = "/client")
  ResponseEntity<ResponseObject> getByClient(@RequestBody(required = true) Client client);

}
