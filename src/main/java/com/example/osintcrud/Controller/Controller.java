package com.example.osintcrud.Controller;

import com.example.osintcrud.Model.UserEntity;
import com.example.osintcrud.Model.UserResponseDTO;
import com.example.osintcrud.Service.SearchService;
import com.example.osintcrud.dto.*;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;



@RestController
public class Controller {




     private final SearchService SearchService;
    public Controller(SearchService searchService) {


        this.SearchService = searchService;
    }


    @PostMapping("/search")
public ResponseEntity<?> search(@Valid @RequestBody SearchRequest request){
        List<UserEntity> result = SearchService.search(request.getQuery());
        SearchResponse response = (SearchResponse) result.stream()
                .map(entity -> new UserResponseDTO(entity.getId(),entity.getFullname(), entity.getEmail()))
                .collect(Collectors.toList());
SearchResponse finalResponse = new SearchResponse("ok",
        request.getQuery(),
        response, // Передаем список DTO
        null);



        return ResponseEntity.ok(finalResponse);
    }

}
