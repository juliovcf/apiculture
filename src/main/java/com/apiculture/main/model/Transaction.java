package com.apiculture.main.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Data
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Transaction {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(unique = true, nullable = false)
  private Long id;

  private double amount;

  private TransactionType transactionType;

  private PaymentType paymentType;

  @ManyToOne
  @JoinColumn(name = "cliente_id", nullable = false)
  private Client client;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  private String description;

  @Column(updatable = false)
  @CreatedDate
  private LocalDateTime createdAt;

  @Column(insertable = false)
  @LastModifiedDate
  private LocalDateTime updatedAt;

  private boolean completed;

}
