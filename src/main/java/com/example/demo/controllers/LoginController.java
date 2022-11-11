package com.example.demo.controllers;

import com.example.demo.dto.LoginDTO;
import com.example.demo.repositories.NutritionistRepository;
import com.example.demo.services.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private final LoginService loginService;
    private final NutritionistRepository repository;

    public LoginController(NutritionistRepository repository) {
        this.repository = repository;
        this.loginService = new LoginService(repository);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO){
        String token = this.loginService.JWTToken(loginDTO.getEmail(), loginDTO.getPassword());

        return new ResponseEntity<String>(token, HttpStatus.OK) ;
    }

}