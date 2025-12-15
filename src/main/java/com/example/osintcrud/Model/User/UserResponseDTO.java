package com.example.osintcrud.Model.User;


import lombok.AllArgsConstructor;

// DTO для ответа клиенту
@AllArgsConstructor
@lombok.Data

public class UserResponseDTO {


    // Поля, которые мы разрешаем передавать клиенту
    private final Long id;
    private final String fullName;
    private final String email;







}