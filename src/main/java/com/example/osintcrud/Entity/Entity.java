package com.example.osintcrud.Entity;

import jakarta.persistence.*;

import lombok.Data;
@Data
@jakarta.persistence.Entity
public class Entity {

    @Id
    private Long ip;
    private Long phone;
    private String email;
    private int number;
    private int pasport;

}
