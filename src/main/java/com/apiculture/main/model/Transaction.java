package com.apiculture.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Transaction {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(unique = true, nullable = false)
  private Long id;

  private TransactionType transactionType;

  private PaymentType paymentType;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private Client client;

  private double amount;

  private String description;

  private boolean completed;

}
