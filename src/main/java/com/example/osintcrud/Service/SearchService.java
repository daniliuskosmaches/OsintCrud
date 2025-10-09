package com.example.osintcrud.Service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;




import com.example.osintcrud.Model.*;
import com.example.osintcrud.Repository.*;

import java.util.List;

@Service
public class SearchService {
    private final UserRepository userRepository;

    public SearchService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    public Map<String, Object> search(String query) {
        Map<String, Object> response = new HashMap<>();
        List<UserEntity> results;

        switch (detectType(query)) {
            case "EMAIL" -> results = userRepository.findByEmail(query);
            case "FULLNAME" -> results = userRepository.findByFullnameContainingIgnoreCase(query);
            case "NUMBER" -> results = userRepository.findByNumber(Integer.parseInt(query));
            case "PASPORT" -> results = userRepository.findByPasport(Integer.parseInt(query));
            default -> throw new IllegalArgumentException("Неизвестный тип запроса");
        }

        response.put("status", "ok");
        response.put("query", query);
        response.put("result", results);

        return response;
    }

    private String detectType(String query) {
        if (query.contains("@")) return "EMAIL";
        if (query.matches("\\d+")) return "NUMBER_OR_PASPORT"; // уточним дальше
        return "FULLNAME";
    }
}


