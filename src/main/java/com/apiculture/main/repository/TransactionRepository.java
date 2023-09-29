package com.apiculture.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apiculture.main.model.Client;
import com.apiculture.main.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

  List<Transaction> findByClient(Client client);

}
