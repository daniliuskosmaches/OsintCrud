package com.example.osintcrud.Controller;

import com.example.osintcrud.Model.User.UserRequestDTO;
import com.example.osintcrud.Model.User.UserResponseDTO;
import com.example.osintcrud.Service.OsintService;
import com.example.osintcrud.Service.Patterns.interfaces.Pattern;
import com.example.osintcrud.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
public class Controller {
    private OsintService osintService;
    private UserService userService;


    @GetMapping
    public ResponseEntity<UserResponseDTO> getUser(@Valid @RequestBody UserRequestDTO userRequestDTO){
        Optional<UserRequestDTO> userResponseDTO = userService.GetOutput(userRequestDTO);
        // 1. Ищем пользователя через бизнес-сервис
        return userService.GetOutput(userRequestDTO)
                .map(user -> {

                    UserResponseDTO response = new UserResponseDTO(
                            userRequestDTO.getIp(),
                            userRequestDTO.getPhone(),
                            userRequestDTO.getEmail()

                    );
                    return ResponseEntity.ok(response);
                })

                .orElseGet(() -> ResponseEntity.notFound().build());


    }


}

