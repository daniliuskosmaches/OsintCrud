package com.example.osintcrud.Service;

import com.example.osintcrud.Service.Patterns.interfaces.Pattern;

import java.util.List;

public class OsintService {
    private final List<Pattern> patterns;

    public OsintService(List<Pattern> patterns) {
        this.patterns = patterns;

    }
    public String identifyType(String input) {
        if (input == null || input.isEmpty()) {
            return "UNKNOWN";
        }


        for (Pattern pattern : patterns) {


            if (pattern.matches(input)) {
                return pattern.getIdentifiedType();
            }
        }

        return "UNKNOWN";
    }
}


