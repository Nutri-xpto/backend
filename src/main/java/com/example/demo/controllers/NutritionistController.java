package com.example.demo.controllers;

import com.example.demo.dto.NutritionistDTO;
import com.example.demo.model.Nutritionist;
import com.example.demo.repositories.NutritionistRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NutritionistController {

    private final NutritionistRepository repository;

    public NutritionistController(NutritionistRepository repository) { this.repository = repository; }

    @GetMapping("/nutritionists")
    ResponseEntity<List<Nutritionist>> getAll(){
        return new ResponseEntity<List<Nutritionist>>(this.repository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/nutritionist")
    ResponseEntity<Nutritionist> create(@RequestBody NutritionistDTO nutri){
        return new ResponseEntity<Nutritionist>(this.repository.save( Nutritionist.dtoToEntity(nutri)), HttpStatus.CREATED );
    }
}
