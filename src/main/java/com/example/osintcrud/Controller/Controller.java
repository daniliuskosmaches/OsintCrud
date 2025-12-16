package com.example.osintcrud.Controller;

import com.example.osintcrud.Model.User.UserRequestDTO;
import com.example.osintcrud.Model.User.UserResponseDTO;
import com.example.osintcrud.Service.SearchService;
import com.example.osintcrud.dto.*;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class Controller {
    @GetMapping
    public ResponseEntity<UserResponseDTO> getUser(@Valid @RequestBody UserRequestDTO userRequestDTO){
        return ;
    }


}

