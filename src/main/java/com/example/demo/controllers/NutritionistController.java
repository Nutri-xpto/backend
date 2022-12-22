package com.example.demo.controllers;

import com.example.demo.dto.NewNutriDTO;
import com.example.demo.dto.PatientDTO;
import com.example.demo.model.Nutritionist;
import com.example.demo.model.Patient;
import com.example.demo.repositories.NutritionistRepository;
import com.example.demo.repositories.PatientRepository;
import com.example.demo.services.NutricionistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NutritionistController {

    private final NutritionistRepository nutricionistRepository;

    private final PatientRepository patientRepository;

    private final NutricionistService service;

    public NutritionistController(NutritionistRepository nutricionistRepository, PatientRepository patientRepository) {
        this.nutricionistRepository = nutricionistRepository;
        this.patientRepository = patientRepository;
        this.service = new NutricionistService(nutricionistRepository, patientRepository);
    }

    @GetMapping("/nutritionists")
    ResponseEntity<List<Nutritionist>> getAllNutricionists(){
        return new ResponseEntity<List<Nutritionist>>(this.nutricionistRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/nutritionist")
    ResponseEntity<Nutritionist> create(@RequestBody NewNutriDTO nutri){
        return new ResponseEntity<Nutritionist>(this.nutricionistRepository.save( Nutritionist.dtoToEntity(nutri)), HttpStatus.CREATED );
    }

    @PostMapping("/patient")
    ResponseEntity<Patient> create(@RequestBody PatientDTO patient){
        return new ResponseEntity<>(this.patientRepository.save( Patient.dtoToEntity(patient)), HttpStatus.CREATED );
    }

    @GetMapping("/patients")
    ResponseEntity<List<Patient>> getAllPatients(){
        return new ResponseEntity<>(this.patientRepository.findAll(), HttpStatus.OK);
    }
    @DeleteMapping("/patient")
    ResponseEntity<Object> delete(@PathVariable Long id) {
        return service.deletePatient(id);
    }
}
