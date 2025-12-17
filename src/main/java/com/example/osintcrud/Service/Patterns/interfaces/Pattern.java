package com.example.osintcrud.Service.Patterns.interfaces;

import com.example.osintcrud.Model.User.UserRequestDTO;

public interface Pattern {
    boolean matches(UserRequestDTO userRequestDTO);
    String getIdentifiedType();


}
