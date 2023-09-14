package com.apiculture.main.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
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

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "role_id")
  private Role role;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "status_id")
  private Status status;

}
