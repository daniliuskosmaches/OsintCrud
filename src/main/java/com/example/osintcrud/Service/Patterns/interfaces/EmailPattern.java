package com.example.osintcrud.Service.Patterns.interfaces;

public interface EmailPattern extends Pattern {
    String getIdentifiedType();
    boolean matches(String input);

}
