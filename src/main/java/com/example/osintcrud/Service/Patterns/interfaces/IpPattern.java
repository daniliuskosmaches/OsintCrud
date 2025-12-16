package com.example.osintcrud.Service.Patterns.interfaces;

public interface IpPattern extends Pattern{
    String getIdentifiedType();
boolean matches(String input);

}
