package com.apiculture.main.service.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiculture.main.dao.TransactionDao;
import com.apiculture.main.exception.GenericException;
import com.apiculture.main.model.Client;
import com.apiculture.main.model.Transaction;
import com.apiculture.main.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

  @Autowired
  TransactionDao dao;

  @Override
  public Transaction create(Transaction transaction) throws GenericException {
    try {
      return dao.create(transaction);
    } catch (Exception e) {
      throw new GenericException(e.getMessage(), e, 400);
    }
  }

  @Override
  public List<Transaction> findAll() throws GenericException {
    try {
      return dao.findAll();
    } catch (Exception e) {
      throw new GenericException(e.getMessage(), e, 400);
    }
  }

  @Override
  public Optional<Transaction> findById(Long id) throws GenericException {
    try {
      return dao.findById(id);
    } catch (Exception e) {
      throw new GenericException(e.getMessage(), e, 400);
    }
  }

  @Override
  public Transaction update(Long id, Transaction transaction) throws GenericException {
    try {
      return dao.update(id, transaction);
    } catch (Exception e) {
      throw new GenericException(e.getMessage(), e, 400);
    }
  }

  @Override
  public int delete(Long id) throws GenericException {
    try {
      return dao.delete(id);
    } catch (Exception e) {
      throw new GenericException(e.getMessage(), e, 400);
    }
  }

  @Override
  public List<Transaction> findByClient(Client client) throws GenericException {
    try {
      return dao.findByClient(client);
    } catch (EntityNotFoundException e) {
      throw new GenericException("No existen notas para " + client, e, 400);
    } catch (Exception e) {
      throw new GenericException(e.getMessage(), e, 500);
    }
  }

}
