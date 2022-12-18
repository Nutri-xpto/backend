package com.example.demo.controllers;

import com.example.demo.dto.PatientDTO;
import com.example.demo.model.Patient;
import com.example.demo.repositories.PatientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {

    private final PatientRepository repository;

    public PatientController(PatientRepository repository) { this.repository = repository; }

    @PostMapping("/patient")
    ResponseEntity<Patient> create(@RequestBody PatientDTO patient){
        return new ResponseEntity<Patient>(this.repository.save( Patient.dtoToEntity(patient)), HttpStatus.CREATED );
    }
}
