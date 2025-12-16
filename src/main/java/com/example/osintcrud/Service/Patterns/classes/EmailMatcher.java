package com.example.osintcrud.Service.Patterns.classes;

import com.example.osintcrud.Service.Patterns.interfaces.EmailPattern;



public class EmailMatcher implements EmailPattern {
    private static final String TYPE = "EMAIL";
    private static final String EMAIL_REGEX =
            "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,63}$";


    @Override
    public String getIdentifiedType() {
        return TYPE;
    }

    public boolean matches(String input) {
        if (input == null) {
            return false;

        }
        return EMAIL_REGEX.matches(input);
    }

}
