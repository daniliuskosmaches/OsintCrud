package com.example.osintcrud.Service.Patterns.classes;

import com.example.osintcrud.Model.User.UserRequestDTO;
import com.example.osintcrud.Service.Patterns.interfaces.PhonePattern;

import java.util.regex.Pattern;


public class PhoneKazakhstan implements PhonePattern {
    private static final String TYPE = "PHONE";
    private static final String KZ_PHONE_REGEX =
            "^(\\+7|8)[\\s-]?(\\(\\d{3}\\)|\\d{3})[\\s-]?(\\d{3})[\\s-]?(\\d{2})[\\s-]?(\\d{2})$";

    private static final Pattern PHONE_PATTERN = Pattern.compile(KZ_PHONE_REGEX);


    @Override
    public String getIdentifiedType() {
        return TYPE;
    }

    @Override
    public boolean matches(UserRequestDTO userRequestDTO) {
        if (userRequestDTO == null ) {
            return false;
        }

        return PHONE_PATTERN.matcher((CharSequence) userRequestDTO).matches();
    }

}
