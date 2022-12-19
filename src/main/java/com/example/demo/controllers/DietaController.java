package com.example.demo.controllers;


import com.example.demo.dto.DietaDTO;
import com.example.demo.model.Dieta;
import com.example.demo.repositories.*;
import com.example.demo.services.DietaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DietaController {

    private final PatientRepository pacientRepository;

    private final NutritionistRepository nutritionistRepository;

    private final DietaRepository dietaRepository;

    private final RefeicaoRepository refeicaoRepository;

    private final ReceitaRepository receitaRepository;

    private final DietaService service;

    public DietaController(PatientRepository pacientRepository, NutritionistRepository nutritionistRepository, DietaRepository dietaRepository, RefeicaoRepository refeicaoRepository, ReceitaRepository receitaRepository) {
        this.pacientRepository = pacientRepository;
        this.nutritionistRepository = nutritionistRepository;
        this.dietaRepository = dietaRepository;
        this.refeicaoRepository = refeicaoRepository;
        this.receitaRepository =  receitaRepository;
        this.service = new DietaService(pacientRepository, nutritionistRepository, dietaRepository, refeicaoRepository, receitaRepository);
    }

    @PostMapping("/dieta")
    ResponseEntity<Dieta> createDieta(@RequestBody DietaDTO dto){
        return new ResponseEntity<Dieta>(this.service.save(dto), HttpStatus.CREATED);
    }
}
