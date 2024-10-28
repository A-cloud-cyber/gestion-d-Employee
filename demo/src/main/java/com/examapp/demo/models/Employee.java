package com.examapp.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable {

    @Id()
    @GeneratedValue
    private Integer id;
    @Column(nullable = false)
    private String cin;
    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private String prenom;
}

