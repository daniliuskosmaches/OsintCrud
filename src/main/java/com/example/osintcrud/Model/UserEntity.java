package com.example.osintcrud.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

public class UserEntity {


    @Id
    private Long id;
    private String Fullname;
    private String email;
    private int number;
    private int pasport;
    private String query;


    public Long getId() {
        return id;

    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFullname() {
        return Fullname;
    }
    public void setFullname(String fullname) {
        Fullname = fullname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public int getPasport() {
        return pasport;
    }
    public void setPasport(int pasport) {
        this.pasport = pasport;
    }


}
