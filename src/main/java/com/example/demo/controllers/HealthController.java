package com.example.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.HealthCheckDTO;
import com.example.demo.services.HealthService;

@RestController
public class HealthController {
    
    @GetMapping("/healthCheck")
    public ResponseEntity<HealthCheckDTO> healthCheck(){
        return new ResponseEntity<HealthCheckDTO>( HealthService.isConnected() , HttpStatus.OK);
    }
    
}
