package com.apiculture.main.dao;

import java.util.List;
import java.util.Optional;

import com.apiculture.main.model.Client;
import com.apiculture.main.model.Transaction;

public interface TransactionDao {

  Transaction create(Transaction transaction);

  List<Transaction> findAll();

  Optional<Transaction> findById(Long id);

  Transaction update(Long id, Transaction transaction);

  int delete(Long id);

  List<Transaction> findByClient(Client client);

}
