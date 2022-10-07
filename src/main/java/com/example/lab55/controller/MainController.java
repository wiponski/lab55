package com.example.lab55.controller;

import com.example.lab55.entity.User;
import com.example.lab55.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MainController {
    private final UserService service;
//    @GetMapping("/create")
//    public ResponseEntity<String> createTable(){
//        return new ResponseEntity<>(service.shouldCreateTable(), HttpStatus.OK);
//    }
//
    @GetMapping("/users")
    public ResponseEntity<List<User>> users(){
        return new ResponseEntity<>(service.getUsers(), HttpStatus.OK);
    }
}
