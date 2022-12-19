package com.example.demo.services;

import com.example.demo.dto.DietaDTO;
import com.example.demo.model.Dieta;
import com.example.demo.model.Refeicao;
import com.example.demo.repositories.*;

import java.util.List;

public class DietaService {

    private final PatientRepository pacientRepository;

    private final NutritionistRepository nutritionistRepository;

    private final DietaRepository dietaRepository;

    private final RefeicaoService refeicaoService;

    private final ReceitaRepository receitaRepository;
    public DietaService(PatientRepository pacientRepository, NutritionistRepository nutritionistRepository, DietaRepository dietaRepository, RefeicaoRepository refeicaoRepository, ReceitaRepository receitaRepository) {
        this.pacientRepository = pacientRepository;
        this.nutritionistRepository = nutritionistRepository;
        this.dietaRepository = dietaRepository;
        this.receitaRepository = receitaRepository;
        this.refeicaoService = new RefeicaoService(refeicaoRepository, this.receitaRepository);
    }

    public Dieta save(DietaDTO dto){
        // Evitar muita chamadas na pilha
        List<Refeicao> dia = dto.getDia();
        Dieta diet = new Dieta(dia,
                this.nutritionistRepository.findById(dto.getNutriID()).get(),
                this.pacientRepository.findById(dto.getPatientID()).get()
                );

        this.refeicaoService.saveAll(dia);

        return this.dietaRepository.save(diet);
    }
}
