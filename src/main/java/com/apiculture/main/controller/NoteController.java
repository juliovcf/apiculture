package com.apiculture.main.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.apiculture.main.model.Client;
import com.apiculture.main.model.Note;
import com.apiculture.main.model.Status;
import com.apiculture.main.utils.ResponseObject;

@RequestMapping("/notes")
public interface NoteController {

  @PostMapping
  ResponseEntity<ResponseObject> create(@RequestBody Note note);

  @GetMapping("/{id}")
  ResponseEntity<ResponseObject> get(@PathVariable Long id);

  @GetMapping()
  ResponseEntity<ResponseObject> get();

  @PutMapping(value = "/{id}")
  ResponseEntity<ResponseObject> update(@PathVariable(required = true) Long id, @RequestBody Note note);

  @DeleteMapping(value = "/{id}")
  ResponseEntity<ResponseObject> delete(@PathVariable(required = true) Long id);

  @PostMapping(value = "/status")
  ResponseEntity<ResponseObject> getByStatus(@RequestBody Status status);

  @PostMapping(value = "/client")
  ResponseEntity<ResponseObject> getByClient(@RequestBody(required = true) Client client);

  @PostMapping(value = "/client_status")
  ResponseEntity<ResponseObject> getByClientAndStatus(@RequestParam int clientId, @RequestParam int statusId);

}
