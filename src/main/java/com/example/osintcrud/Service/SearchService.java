package com.example.osintcrud.Service;

import com.example.osintcrud.dto.SearchResponse;
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



    public SearchResponse search(String query) {
        if (query == null || query.isBlank()) {
            throw new IllegalArgumentException("Запрос не может быть пустым");
        }
        if (query.length() > 255) {
            throw new IllegalArgumentException("запрос не должен быть гроромосздким");
        }

        Map<String, Object> response = new HashMap<>();
        List<UserEntity> results;


        switch (detectType(query)) {
            case "EMAIL" -> results = userRepository.findByEmail(query);
            case "FULLNAME" -> results = userRepository.findByFullnameContainingIgnoreCase(query);
            case "NUMBER" -> results = userRepository.findByNumber(Integer.parseInt(query));
            case "PASPORT" -> results = userRepository.findByPasport(Integer.parseInt(query));
            default -> throw new IllegalArgumentException("Неизвестный тип запроса");
        }

        SearchResponse ok = new SearchResponse(
                "ok",                          // статус
                query,                         // запрос
                results,                       // результат поиска
                "Найдено " + results.size() + " записей" // сообщение
        );
        return ok;



    }

    private String detectType(String query) {
        query = query.trim();

        if (query.contains("@")) {
            return "EMAIL";
        }

        if (query.matches("\\d{1,3}(\\.\\d{1,3}){3}")) {
            return "IP";
        }

        if (query.matches("\\+?\\d{10,15}")) {
            return "PHONE";
        }

        if (query.matches("[A-Z]{2}\\d{6}")) { // пример: AB123456
            return "PASSPORT";
        }

        if (query.matches("[А-ЯЁA-Z][а-яёa-z]+\\s+[А-ЯЁA-Z][а-яёa-z]+")) {
            return "FULLNAME";
        }

        return "USERNAME";
    }

}


