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
import com.apiculture.main.model.Status;
import com.apiculture.main.utils.ResponseObject;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Client", description = "Client management endpoints")
@RequestMapping("/clients")
public interface ClientController {

  @Operation(summary = "Retrieve all Clients", description = "Get all Client objects. The expected response inside data object is a Client list.")
  @ApiResponses({
    @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = ResponseObject.class), mediaType = "application/json") }),
    @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
    @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) })
  })
  @GetMapping
  ResponseEntity<ResponseObject> get();

  @Operation(summary = "Create a Client", description = "Create a Client object passing that object as the request body. The expected response inside data object is a Client object.")
  @ApiResponses({
    @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = ResponseObject.class), mediaType = "application/json") }),
    @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
    @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) })
  })
  @PostMapping
  ResponseEntity<ResponseObject> create(@RequestBody Client client);

  @Operation(summary = "Retrieve a Client by id", description = "Get a Client object by specifying its id. The expected response inside data object is a Client object.")
  @ApiResponses({
    @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = ResponseObject.class), mediaType = "application/json") }),
    @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
    @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) })
  })
  @GetMapping("/{id}")
  ResponseEntity<ResponseObject> get(@Parameter(description = "Client id, starting from 1") @PathVariable(required = true) int id);

  @Operation(summary = "Update a Client", description = "Update a Client object passing that object as the request body and its id as a parameter. The expected response inside data object is a Client object.")
  @ApiResponses({
    @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = ResponseObject.class), mediaType = "application/json") }),
    @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
    @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) })
  })
  @PutMapping(value = "/{id}")
  ResponseEntity<ResponseObject> update(@Parameter(description = "Client id, starting from 1") @PathVariable(required = true) int id, @RequestBody Client client);

  @Operation(summary = "Delete a Client by id", description = "Delete a Client object by specifying its id. The expected response inside data object is an int.")
  @ApiResponses({
    @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = ResponseObject.class), mediaType = "application/json") }),
    @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
    @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) })
  })
  @DeleteMapping(value = "/{id}")
  ResponseEntity<ResponseObject> delete(@Parameter(description = "Client id, starting from 1") @PathVariable(required = true) int id);

  @Operation(summary = "Retrieve a list of Clients by Status", description = "Get a list of Client objects by specifying its Status. The expected response inside data object is a Client object.")
  @ApiResponses({
    @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = ResponseObject.class), mediaType = "application/json") }),
    @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
    @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) })
  })
  @PostMapping(value = "/status")
  ResponseEntity<ResponseObject> getByStatus(@RequestBody Status status);

}
