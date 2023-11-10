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

import io.swagger.v3.oas.annotations.Operation;

@RequestMapping("/notes")
public interface NoteController {

  @Operation(summary = "Create a Note", description = "Create a Note object passing that object as the request body. The expected response inside data object is a Note object.")
  @PostMapping
  ResponseEntity<ResponseObject> create(@RequestBody Note note);

  @Operation(summary = "Retrieve a Note by id", description = "Get a Note object by specifying its id. The expected response inside data object is a Note object.")
  @GetMapping("/{id}")
  ResponseEntity<ResponseObject> get(@PathVariable Long id);

  @Operation(summary = "Retrieve all Notes", description = "Get all Note objects. The expected response inside data object is a Note list.")
  @GetMapping()
  ResponseEntity<ResponseObject> get();

  @Operation(summary = "Update a Note", description = "Update a Note object passing that object as the request body and its id as a parameter. The expected response inside data object is a Note object.")
  @PutMapping(value = "/{id}")
  ResponseEntity<ResponseObject> update(@PathVariable(required = true) Long id, @RequestBody Note note);

  @Operation(summary = "Delete a Note", description = "Delete a Note object by specifying its id. The expected response is a message.")
  @DeleteMapping(value = "/{id}")
  ResponseEntity<ResponseObject> delete(@PathVariable(required = true) Long id);

  @Operation(summary = "Retrieve all Notes by Status", description = "Get all Note objects by specifying its Status. The expected response inside data object is a Note list.")
  @PostMapping(value = "/status")
  ResponseEntity<ResponseObject> getByStatus(@RequestBody Status status);

  @Operation(summary = "Retrieve all Notes by Client", description = "Get all Note objects by specifying its Client. The expected response inside data object is a Note list.")
  @PostMapping(value = "/client")
  ResponseEntity<ResponseObject> getByClient(@RequestBody(required = true) Client client);

  @Operation(summary = "Retrieve all Notes by Client and Status", description = "Get all Note objects by specifying its Client and Status. The expected response inside data object is a Note list.")
  @PostMapping(value = "/client_status")
  ResponseEntity<ResponseObject> getByClientAndStatus(@RequestParam int clientId, @RequestParam int statusId);

}
