package com.example.osintcrud.Controller;

import com.example.osintcrud.Model.UserEntity;
import com.example.osintcrud.Service.SearchService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class Controller {
    private final SearchService SearchService;
    public Controller(SearchService SearchService, SearchService searchService) {


        this.SearchService = searchService;
    }
    @PostMapping("/search")
public ResponseEntity<?> search(@Valid @RequestBody UserEntity search){
        Map<String, Object> result = SearchService.search(search.getQuery());
        return ResponseEntity.ok(result);
    }

}
