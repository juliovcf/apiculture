package com.apiculture.main.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.apiculture.main.dao.TransactionDao;
import com.apiculture.main.model.Client;
import com.apiculture.main.model.Transaction;
import com.apiculture.main.repository.TransactionRepository;

@Repository
public class TransactionDaoImpl implements TransactionDao {

  @Autowired
  private TransactionRepository repository;

  @Override
  public Transaction create(Transaction transaction) {
    return repository.save(transaction);
  }

  @Override
  public List<Transaction> findAll() {
    return repository.findAll();
  }

  @Override
  public Optional<Transaction> findById(Long id) {
    return repository.findById(id);
  }

  @Override
  public Transaction update(Long id, Transaction transaction) {
    transaction.setId(id);
    return repository.save(transaction);
  }

  @Override
  public int delete(Long id) {
    try {
      repository.deleteById(id);
      return 0; // Éxito
    } catch (EmptyResultDataAccessException e) {
      return 1; // No se encontró un registro con el ID especificado
    } catch (Exception e) {
      return -1; // Ocurrió un error inesperado
    }
  }

  @Override
  public List<Transaction> findByClient(Client client) {
    return repository.findByClient(client);
  }

}
