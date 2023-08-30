package com.apiculture.main.model;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Data
@Entity
public class Socio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellidos;
    private String dni;
    private String direccion;
    private String cp;
    private String poblacion;
    private String rega;
    private Nacionalidad nacionalidad;
    private int numColmenas;
    private String telefono;
    private String email;
    private boolean estado;

}