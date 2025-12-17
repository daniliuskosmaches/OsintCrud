package com.example.osintcrud.Service;

import com.example.osintcrud.Model.User.UserRequestDTO;
import com.example.osintcrud.Service.Patterns.interfaces.Pattern;

import java.util.List;

public class OsintService {
    private final List<Pattern> patterns;

    public OsintService(List<Pattern> patterns) {
        this.patterns = patterns;

    }
    public String identifyType(UserRequestDTO userRequestDTO) {
        if (userRequestDTO == null) {
            return "UNKNOWN";
        }


        for (Pattern pattern : patterns) {


            if (pattern.matches(userRequestDTO)) {
                return pattern.getIdentifiedType();
            }
        }

        return "UNKNOWN";
    }
}


