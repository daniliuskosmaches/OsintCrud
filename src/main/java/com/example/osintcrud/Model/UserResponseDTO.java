package com.example.osintcrud.Model;


import lombok.AllArgsConstructor;

import java.util.List;

// DTO для ответа клиенту
@AllArgsConstructor
@lombok.Data

public class UserResponseDTO {


    // Поля, которые мы разрешаем передавать клиенту
    private final Long id;
    private final String fullName;
    private final String email;







}