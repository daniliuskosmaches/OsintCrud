package com.example.osintcrud.dto;


import lombok.AllArgsConstructor;


@AllArgsConstructor
@lombok.Data
public class SearchResponse {



    // СТАНДАРТНЫЕ ПОЛЯ ДЛЯ КОНТРАКТА API
    private final String status; // "ok" или "error"
    private final String query;  // Эхо исходного запроса
    private final String message;
    private final String response;// Сообщение об ошибке или дополнительная информация

    public SearchResponse(String ok, String query, SearchResponse response, Object response1) {
        this.status = ok;
        this.query = query;
        this.message = response.getMessage();
        this.response = response1.toString();
    }

    // ПОЛЕ ДЛЯ ДАННЫХ
    // ИСПРАВЛЕНИЕ: Строгая типизация List<UserEntity>


    // ------------------------------------------------------------------------
    // Конструктор для создания объекта
    // Используем final поля для создания иммутабельного (неизменяемого) объекта
 }

 // Сеттеры УДАЛЕНЫ, так как DTO должен быть иммутабельным (неизменяемым) после создания.
    // Если вам нужны сеттеры, вы можете их вернуть, но иммутабельность — лучшая практика для DTO.
