package com.example.osintcrud.Controller;

import com.example.osintcrud.Model.UserEntity;
import com.example.osintcrud.Service.SearchService;
import com.example.osintcrud.dto.*;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class Controller {
    private final SearchService SearchService;
    public Controller(SearchService searchService) {


        this.SearchService = searchService;
    }


    @PostMapping("/search")
public ResponseEntity<?> search(@Valid @RequestBody SearchRequest request){
        SearchResponse response = (SearchResponse) SearchService.search(request.getQuery());
        return ResponseEntity.ok(response);
    }

}
