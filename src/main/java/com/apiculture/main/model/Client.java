package com.apiculture.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private String dni;
    private String adress;
    private String postalCode;
    private String location;
    private String rega;
    private Nationality nationality;
    private int beehives;
    private String phone;
    private String email;
    private Status client_status;

}