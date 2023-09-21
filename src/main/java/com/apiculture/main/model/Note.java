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
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Note {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(unique = true, nullable = false)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "client_id")
  private Client client;

  private String note;

  @ManyToOne
  @JoinColumn(name = "status_id")
  private Status status;

  @Column(updatable = false)
  @CreatedDate
  private LocalDateTime createdAt;

  @Column(insertable = false)
  @LastModifiedDate
  private LocalDateTime updatedAt;

}
