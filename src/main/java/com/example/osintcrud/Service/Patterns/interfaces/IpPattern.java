package com.example.osintcrud.Service.Patterns.interfaces;

import com.example.osintcrud.Model.User.UserRequestDTO;

public interface IpPattern extends Pattern{
    String getIdentifiedType();
boolean matches(UserRequestDTO userRequestDTO);

}
