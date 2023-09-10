package com.apiculture.main.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;

@Data
@Entity
public class Client {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String surname;

  private String dni;

  private String adress;

  private String postalCode;

  private String location;

  private String rega;

  private int beehives;

  private String acount;

  private Double insuranceAmount;

  private String phone;

  private String email;

  private String note;

  @ManyToOne
  @JoinColumn(name = "nationality_id")
  private Nationality nationality;

  @ManyToOne
  @JoinColumn(name = "status_id")
  private Status status;

  @CreatedDate // Marca este campo como la fecha de creación
  private Date createdAt;

  @LastModifiedDate // Marca este campo como la fecha de modificación
  private Date updatedAt;

  @CreatedBy
  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user; // Usuario que modificó el registro

}
