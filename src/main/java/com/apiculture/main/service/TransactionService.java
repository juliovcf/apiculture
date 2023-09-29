package com.apiculture.main.service;

import java.util.List;
import java.util.Optional;

import com.apiculture.main.exception.GenericException;
import com.apiculture.main.model.Client;
import com.apiculture.main.model.Transaction;

public interface TransactionService {

  Transaction create(Transaction transaction) throws GenericException;

  List<Transaction> findAll() throws GenericException;

  Optional<Transaction> findById(Long id) throws GenericException;

  Transaction update(Long id, Transaction transaction) throws GenericException;

  int delete(Long id) throws GenericException;

  List<Transaction> findByClient(Client client) throws GenericException;

}
