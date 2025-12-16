package com.example.osintcrud.Service.Patterns.interfaces;

public interface PhonePattern extends Pattern {
    String getIdentifiedType();
    boolean matches(String input);

}
