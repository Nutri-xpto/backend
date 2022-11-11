package com.example.demo.repositories;

import com.example.demo.model.Nutritionist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NutritionistRepository extends JpaRepository<Nutritionist, Long> {
    Nutritionist findNutritionistByEmail(String email);
}
