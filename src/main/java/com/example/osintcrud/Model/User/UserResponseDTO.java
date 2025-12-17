package com.example.osintcrud.Model.User;


import lombok.Data;

@Data

public class UserResponseDTO {


    // Поля, которые мы разрешаем передавать клиенту
    private final Long ip;
    private final Long phone;
    private final String email;







}