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

@RequestMapping("/status")
public interface StatusController {

  @PostMapping
  ResponseEntity<ResponseObject> create(@RequestBody Status status);

  @GetMapping("/{id}")
  ResponseEntity<ResponseObject> get(@PathVariable int id);

  @GetMapping()
  ResponseEntity<ResponseObject> get();

  @PutMapping(value = "/{id}")
  ResponseEntity<ResponseObject> update(@PathVariable(required = true) int id, @RequestBody Status status);

  @DeleteMapping(value = "/{id}")
  ResponseEntity<ResponseObject> delete(@PathVariable(required = true) int id);

}
