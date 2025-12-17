package com.example.osintcrud.Service.Patterns.classes;

import com.example.osintcrud.Model.User.UserRequestDTO;
import com.example.osintcrud.Service.Patterns.interfaces.IpPattern;

public class IpMatcher implements IpPattern {
    private static final String TYPE = "IP";
    // Проверяет, что каждый октет находится в диапазоне 0-255
    private static final String IPV4 =
            "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";


    @Override
    public String getIdentifiedType() {
        return TYPE;
    }

    @Override
    public boolean matches(UserRequestDTO userRequestDTO) {
        if (userRequestDTO == null) {
            return false;
        }

        return IPV4.matches(String.valueOf(userRequestDTO.getIp()));
    }
}
