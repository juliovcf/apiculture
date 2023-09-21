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
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "\"user\"")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(unique = true, nullable = false)
  private int id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String surname;

  @Column(nullable = false, name = "user_name")
  private String username;

  @Column(nullable = false)
  private String password;

  private String phone;

  private String email;

  @ManyToOne
  @JoinColumn(name = "role_id")
  private Role role;

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
