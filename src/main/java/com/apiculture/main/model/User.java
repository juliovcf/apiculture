package com.apiculture.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    @Column(nullable = false, columnDefinition = "integer default 1")
    private Role user_role;

    @ManyToOne
    private Status user_status;

}